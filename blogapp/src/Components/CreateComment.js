import { useState } from "react";
import { useHref, useParams, Link } from "react-router-dom";

import { Button, Form, Grid, TextArea, Card } from "semantic-ui-react";

export function CreateComment(props) {
  // const params = useParams();
  const listUrl = useHref("/:id");
  // const [post, setPost] = useState("");
  const [author, setAuthor] = useState("");
  const [text, setText] = useState("");

  const createComment = async () => {
    fetch(`api/v1/posts/comments/` + props.postId, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        author,
        text,
      }),
    })
      .then(applyResult)
      .then(() => (window.location = listUrl));
  };

  const clear = () => {
    setAuthor("");
    setText("");
  };

  const applyResult = (result) => {
    if (result.ok) {
      clear();
    } else {
      document.getElementById("author").style.borderColor = "red";
      window.alert(
        "Be autoriaus vardo sukurti neleidziama. Klaidos statusas: " +
          result.status
      );
    }
  };

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={5}></Grid.Column>
        <Grid.Column width={6}>
          <Form>
            <Form.Field>
              <label>Komentaro autorius</label>
              <input
                placeholder="Įrašo pavadinimas"
                value={author}
                onChange={(e) => setAuthor(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Komentaro tekstas</label>
              <TextArea
                placeholder="Komentaro tekstas"
                value={text}
                onChange={(e) => setText(e.target.value)}
              />
            </Form.Field>
            <Button
              type="submit"
              className="controls"
              basic 
              color='blue'
              onClick={createComment}
            >
              <Link to={"/" + props.id}>Komentuoti</Link>
            </Button>
          </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
