import React, { useEffect, useState } from "react";
import { NavLink, Link } from "react-router-dom";
import { Button, Grid, Card, Container, Divider } from "semantic-ui-react";
import { Menu } from "./Menu";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function ViewPosts() {
  const [posts, setPosts] = useState([]);

  const fetchPosts = async () => {
    fetch(`/api/v1/posts/`)
      .then((response) => response.json())
      .then((jsonRespones) => setPosts(jsonRespones));
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  return (
    <div>
      <Container>
        <Grid columns={3}>
          <Grid.Column width={6}></Grid.Column>
          <Grid.Column width={6} textAlign="center">
            <Menu />
            <Divider hidden />
            <Card.Group>
              {posts.map((post) => (
                <Card key={post.id} fluid>
                  <Card.Content>
                    <Card.Header>{post.postName}</Card.Header>
                    <Card.Meta>{post.published}</Card.Meta>
                    <Card.Description>{post.text}</Card.Description>
                    <Card.Meta className="button1">
                      <Button className="button1">
                        <Link to={"/view/" + post.id}>Skaityti daugiau</Link>
                      </Button>
                    </Card.Meta>
                  </Card.Content>
                </Card>
              ))}
            </Card.Group>
          </Grid.Column>
          <Grid.Column width={6}></Grid.Column>
        </Grid>
      </Container>
    </div>
  );
}
