import express from "express";
import { generateUploadURL } from "./scripts/s3.js";

const app = express();
const hostname = "127.0.0.1";
const port = 3000;

app.use(express.static("front"));

app.get("/s3Url", async (req, res, next) => {
    try {
        const url = await generateUploadURL();
        res.send({ url });
    } catch (err) {
        next(err);
    }
});

app.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});
