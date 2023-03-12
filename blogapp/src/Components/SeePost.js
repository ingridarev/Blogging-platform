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
import { CreateComment } from "./CreateComment";
import { Menu } from "./Menu";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function SeePost() {
  const params = useParams();
  const [post, setPost] = useState({});

  useEffect(() => {
    fetch("/api/v1/posts/" + params.id)
      .then((response) => response.json())
      .then(setPost);
  }, [params.id]);

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={6}></Grid.Column>
        <Grid.Column width={6}>
          <Menu />
          <Card.Group>
            <Card fluid>
              <Card.Content>
                <Card.Header>{post.postName}</Card.Header>
                <Card.Meta>{post.published}</Card.Meta>
                <Card.Description>{post.text}</Card.Description>
              </Card.Content>
            </Card>
          </Card.Group>
          <Divider hidden />
          <CreateComment />
        </Grid.Column>
        <Grid.Column width={6}></Grid.Column>
      </Grid>
    </div>
  );
}