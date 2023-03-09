import React, { useState } from "react";
import { NavLink, useHref } from "react-router-dom";
import { Button, Form, Grid, Icon, Input, Segment, TextArea } from "semantic-ui-react";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function CreatePost() {
  const listUrl = useHref("/");
  const [hide, setHide] = useState(false);
  const [postName, setPostName] = useState("");
  const [text, setText] = useState("");
  const [posts, setPosts] = useState([]);

  const createPost = () => {
    fetch("/api/v1/posts", {
      method: "POST",
      headers: JSON_HEADERS,
      body: JSON.stringify({
        postName,
        text,
      }),
    })
      .then(applyResult)
      .then(() => (window.location = listUrl));
  };

  const applyResult = (result) => {
    const clear = () => {
      setHide(true);
    };
    if (result.ok) {
      clear();
    } else {
      window.alert("Nepavyko sukurt: " + result.status);
    }
  };

  const fetchPosts = async () => {
    fetch(`/api/v1/posts/`)
      .then((response) => response.json())
      .then((jsonRespones) => setPosts(jsonRespones));
  };

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={5}></Grid.Column>
        <Grid.Column width={6}>
        <Form>
        <Form.Field>
                  <label>Įrašo pavadinimas</label>
                  <input
                    placeholder="Įrašo pavadinimas"
                    value={postName}
                    onChange={(e) => setPostName(e.target.value)}
                  />
                </Form.Field>
                <Form.Field>
                  <label>Įrašo tekstas</label>
                  <TextArea
                    placeholder="Įrašo tekstas"
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                  />
                </Form.Field>
                <Button
                    type="submit"
                    className="controls"
                    primary
                    onClick={createPost}
                  >
                    Sukurti
                  </Button>
        </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
