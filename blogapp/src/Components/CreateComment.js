import { useState, useEffect } from "react";
import { useHref, useParams, Link } from "react-router-dom";

import {
  Button,
  Form,
  Grid,
  TextArea,
  Divider,
  Comment,
  Header,
} from "semantic-ui-react";

export function CreateComment() {
  const params = useParams();
  // const listUrl = useHref(`/${params.id}`);
  const [author, setAuthor] = useState("");
  const [text, setText] = useState("");
  const [comments, setComments] = useState([]);

  const createComment = () => {
    fetch(`/api/v1/posts/comments/${params.id}`, {
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
      // .then(() => (window.location = listUrl));
  };

  const clear = () => {
    setAuthor("");
    setText("");
  };

  const applyResult = (result) => {
    if (result.ok) {
      clear();
      fetch(`/api/v1/posts/comments/${params.id}`)
      .then((response) => response.json())
      .then(setComments);
    } else {
      document.getElementById("author").style.borderColor = "red";
      window.alert(
        "Be autoriaus vardo sukurti neleidziama. Klaidos statusas: " +
          result.status
      );
    }
  };

  useEffect(() => {
    fetch(`/api/v1/posts/comments/${params.id}`)
      .then((response) => response.json())
      .then(setComments);
  }, [params.id]);

  return (
    <div>
      <Divider hidden />
      <Grid centered>
        <Grid.Column>
          <Form>
            <Form.Field>
              <label>Comment author</label>
              <input
                placeholder="Author"
                value={author}
                onChange={(e) => setAuthor(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Comment text</label>
              <TextArea
                placeholder="Text"
                value={text}
                onChange={(e) => setText(e.target.value)}
              />
            </Form.Field>
            <Button
              type="submit"
              className="controls"
              basic
              color="blue"
              onClick={createComment}
            >
              Leave comment
            </Button>
          </Form>

          <Comment.Group>
            <Header as="h3" dividing>
              Comments
            </Header>
            <Comment>
              {comments.map((comment) => (
                <Comment.Content key={comment.id}>
                  <Comment.Author as="a">{comment.author}</Comment.Author>
                  <Comment.Metadata>
                    <div>{comment.published}</div>
                  </Comment.Metadata>
                  <Comment.Text>{comment.text}</Comment.Text>
                  <Divider hidden />
                </Comment.Content>
              ))}
            </Comment>
          </Comment.Group>
        </Grid.Column>
      </Grid>
    </div>
  );
}
