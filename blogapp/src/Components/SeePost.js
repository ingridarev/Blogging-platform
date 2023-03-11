import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import {
  Button,
  Grid,
  Divider,
  Card,
  Header,
  Comment,
} from "semantic-ui-react";
import { Menu } from "./Menu";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function SeePost() {
  const params = useParams();
  const [comments, setComments] = useState([]);
  const [post, setPost] = useState({});
 

  useEffect(() => {
    fetch("/api/v1/posts/" + params.id)
      .then((response) => response.json())
      .then(setPost);
  }, [params]);

  useEffect(() => {
    fetch("/api/v1/comments/" + params.id)
      .then((response) => response.json())
      .then(setComments);
  }, []);

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={6}></Grid.Column>
        <Grid.Column width={6}>
        <Menu />
          <Card.Group >
            <Card fluid>
              <Card.Content >
                <Card.Header>{post.postName}</Card.Header>
                <Card.Meta>{post.published}</Card.Meta>
                <Card.Description>{post.text}</Card.Description>
              </Card.Content>
            </Card>
          </Card.Group>
          <Divider hidden />
          <Grid.Row centered>
            <Link to="/createComment">
              <Button basic color="blue">
                Rašyti naują komentarą
              </Button>
            </Link>
          </Grid.Row>

          <Comment.Group>
            <Header as="h3" dividing>
              Komentarai
            </Header>
            <Comment>
              {comments.map((comment) => (
                <Comment.Content key={comment.id}>
                  <Comment.Author as="a">{comment.author}</Comment.Author>
                  <Comment.Metadata>
                    <div>{comment.published}</div>
                  </Comment.Metadata>
                  <Comment.Text>{comment.text}</Comment.Text>
                  <Divider hidden/>
                </Comment.Content>
              ))}
            </Comment>
          </Comment.Group>
        </Grid.Column>
        <Grid.Column width={6}></Grid.Column>
      </Grid>
    </div>
  );
}

export default SeePost;

