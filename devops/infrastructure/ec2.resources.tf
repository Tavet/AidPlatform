resource "aws_security_group" "bastion_sg" {
  name        = "ssh-bastion"
  description = "SSH Bastion Hosts"
  vpc_id      = aws_vpc.aid_platform.id

  ingress {
    description = "SSH"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name    = "aidplatform-ssh-bastion"
    Project = "AidPlatform"
  }
}
