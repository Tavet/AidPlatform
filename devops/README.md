# AidPlatform DevOps

There are currently two folders:

- AMI
  - You can find in this folder the development of Amazon Machine Images ready for operation.
  - Tech stack: Packer. AWS. Bash scripts.

- Infrastructure
  - Here's all the infrastructure of the project. There are the resources such as VPC, networks, machines, and everything the application needs to be production-ready.

It's important to generate or use an existing SSH key to connect to the EC2 instance.

Generating a new SSH key:
 ```ssh-keygen -t rsa -P "" -f aws-ec2```