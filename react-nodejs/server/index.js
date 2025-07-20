// const express = require('express')
// const {ApolloServer} = require('@apollo/server')
// const Bodyparser = require('body-parser')
// const cors = require('cors')     
// const {expressMiddleware}  = require('@apollo/server/express4')


// async function startServer() {
//     const app = express();
//     const server = new ApolloServer({
//         typeDefs: `
//         type Todo {
//         id: ID!
//         title: String!
//         }

//         type Query{
//         getTodos : [Todo]
//         }
//         `,
//         resolvers: {}
//     })
//     app.use(express.json())

//     // app.use(Bodyparser.json())
//     app.use(cors())
//     await server.start()
//     app.use("/graphql", expressMiddleware(server))
//     app.listen(8080, ()=> {console.log("sergver started at 8080 port")})


// }

// startServer();
process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';

const express = require('express');
const { ApolloServer } = require('@apollo/server');
const { expressMiddleware } = require('@apollo/server/express4');
const bodyParser = require('body-parser');
const cors = require('cors');
const axios = require('axios')
// const https = require('https')

async function startServer() {
  const app = express();

  app.use(cors());
  app.use(bodyParser.json());

//    const agent = new https.Agent({
//   rejectUnauthorized: false, // ⚠️ Not recommended for production
// });

 

  const server = new ApolloServer({
    typeDefs: `
      type Todo {
        id: ID!
        title: String!
        userId: String!
        user: User
      }
        type User {
        id: ID!
        name: String!
        username: String!
        email: String!
        }

      type Query {
        getTodos(userId: ID!): [Todo]
        getUsers: [User]
        getUser(id:ID!): User
  }
    `,
    resolvers: {
      Todo: {
        user: async (todo) => (await axios.get(`https://jsonplaceholder.typicode.com/users/${todo.userId}`)).data,
      },
      Query: {
        // getTodos: () => [
        //   { id: '1', title: 'Learn GraphQL' },
        //   { id: '2', title: 'Build something cool' }
        // ]
        // getTodos: async () => (await axios.get("https://jsonplaceholder.typicode.com/todos")).data,
         getTodos: async (_, { userId }) => {
      const res = await axios.get('https://jsonplaceholder.typicode.com/todos');
      return res.data.filter(todo => String(todo.userId) === String(userId));
       },
        getUsers: async () => (await axios.get("https://jsonplaceholder.typicode.com/users")).data,
        getUser: async(parent, {id} ) => (await axios.get(`https://jsonplaceholder.typicode.com/users/${id}`)).data,
      }
    }
  });

  await server.start();

  app.use('/graphql', expressMiddleware(server));

  app.listen(8080, () => {
    console.log('🚀 Server running at http://localhost:8080/graphql');
  });
}

startServer();


