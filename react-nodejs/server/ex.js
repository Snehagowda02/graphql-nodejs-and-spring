process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';// certificate issue
const express = require('express')
const {ApolloServer} = require('@apollo/server')
const {expressMiddleware} = require('@apollo/server/express4')
const cors = require('cors')
const bodyparser = require('body-parser')
const axios = require('axios')


async function startServer(){
    const app = express();
    app.use(cors())
    app.use(bodyparser.json())


    const server = new ApolloServer({
        typeDefs: `
        type Todo{
            title: String!
            id: ID!
            userId: String!
            user: User

        }
        type User{
            id: ID!
            name: String
            }
        type Query{
            getTodos: [Todo]
            getUser: [User]
    }
        `
        , resolvers: {
            Query:{
            getTodos: async () => (await axios.get('https://jsonplaceholder.typicode.com/todos')).data,
            getUser: async () => (await axios.get('https://jsonplaceholder.typicode.com/users')).data,

             } }
    })

    await server.start();
    app.use('/graphql', expressMiddleware(server));
    app.listen(8080, () => {
        console.log('appl staerted')
    })
}

startServer();