import './App.css';
// import  { ApolloClient, InMemoryCache } from '@apollo/client'
import {useQuery, gql} from '@apollo/client';

const query = gql`
query GetAllTodosqithUser {
  getTodos {
        title
        id
        userId
        user{
          name
          email
        }
    }
} `;


function App() {
  const {data, loading} = useQuery(query);

  if(loading) return <h1> loading.. </h1>

  // return (
  //   <div className="App">
  //    {JSON.stringify(data)}
  //    </div>
  // );
  return (
    <div className="App"> 
        <table>
          <tbody>
            {data.getTodos.map((todo) => (
        <tr key={todo.id}>
          <td>{todo.title}</td>
          <td>{todo.user.name}</td>
        </tr>
          ))}
        </tbody>
        </table>
        </div>
  );
}

export default App;
