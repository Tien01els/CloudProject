import aws from "aws-sdk";
import dotenv from "dotenv";
import crypto from "crypto";
import { promisify } from "util";

const randomBytes = promisify(crypto.randomBytes);
dotenv.config();

const region = "us-west-2";
const bucketName = "upload-profile-s3-bucket";
const accessKeyId = process.env.AWS_ACCESS_KEY_ID;
const secretKeyId = process.env.AWS_SECRET_ACCESS_KEY;

const s3 = new aws.S3({
    region,
    accessKeyId,
    secretKeyId,
    signatureVersion: "v4",
});

export async function generateUploadURL() {
    const rawBytes = await randomBytes(16);
    const imageName = rawBytes.toString("hex");

    const params = {
        Bucket: bucketName,
        Key: imageName,
        Expires: 60,
    };

    const uploadURL = await s3.getSignedUrlPromise("putObject", params);
    return uploadURL;
}
