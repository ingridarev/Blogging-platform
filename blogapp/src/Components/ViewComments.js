// import React, { useEffect, useState } from "react";
// import { NavLink, Link } from "react-router-dom";
// import { Grid, Button, Comment, Form, Header, Divider } from "semantic-ui-react";

// const JSON_HEADERS = {
//   "Content-Type": "application/json",
// };

// export function ViewComments() {
  
//   const [comments, setComments] = useState([]);

//   const fetchComments = async () => {
//     fetch(`/api/v1/comments/` + params.id)
//       .then((response) => response.json())
//       .then((jsonRespones) => setComments(jsonRespones));
//   };

//   useEffect(() => {
//     fetchComments();
//   }, []);

//   return (
//     <div>
//       <Grid columns={3}>
//         <Grid.Column width={6}></Grid.Column>
//         <Grid.Column width={6}>
//           <Comment.Group>
//             <Header as="h3" dividing>
//               Komentarai
//             </Header>
//             <Comment>
//               {comments.map((comment) => (
//                 <Comment.Content key={comment.id}>
//                   <Comment.Author as="a">{comment.author}</Comment.Author>
//                   <Comment.Metadata>
//                     <div>{comment.published}</div>
//                   </Comment.Metadata>
//                   <Comment.Text>{comment.text}</Comment.Text>
//                   <Divider hidden/>
//                 </Comment.Content>
//               ))}
//             </Comment>
//           </Comment.Group>
//         </Grid.Column>
//         <Grid.Column width={6}></Grid.Column>
//       </Grid>
//     </div>
//   );
// }
