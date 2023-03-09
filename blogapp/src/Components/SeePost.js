import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import {
  Button,
  Grid,
  Icon,
  Input,
  Segment,
  Table,
  Divider,
  List,
  Form,
  Select,
  Card,
  Header,
  TextArea,
  Comment,
} from "semantic-ui-react";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function SeePost() {
  const params = useParams();
  const [comments, setComments] = useState([]);
  const [posts, setPosts] = useState({
    postName: "",
    text: "",
    modifiedDate: "",
  });

  useEffect(() => {
    fetch("/api/v1/posts/view/" + params.id)
      .then((response) => response.json())
      .then(setPosts);
  }, [params]);

  useEffect(() => {
    fetch(`/api/v1/posts/${params.id}/comments/`)
      .then((response) => response.json())
      .then(setComments);
  }, [params]);

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={6}></Grid.Column>
        <Grid.Column width={6}>
          <Card.Group >
            <Card fluid>
              <Card.Content >
                <Card.Header>{posts.postName}</Card.Header>
                <Card.Meta>{posts.published}</Card.Meta>
                <Card.Description>{posts.text}</Card.Description>
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
          {/* <ViewComments /> */}

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
