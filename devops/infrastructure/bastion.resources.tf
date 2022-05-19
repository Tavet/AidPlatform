data "aws_ami" "bastion_ami" {
  executable_users = ["self"]
  most_recent      = true
  name_regex       = "^bastion-aid-platform-(.*)"
  owners           = ["self"]

  filter {
    name   = "name"
    values = ["bastion-aid-platform-*"]
  }

  filter {
    name   = "root-device-type"
    values = ["ebs"]
  }

  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }
}

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

resource "aws_instance" "bastion_instance" {
  ami               = data.aws_ami.bastion_ami
  instance_type     = "t2.micro"
  availability_zone = var.availability_zone

  security_groups = [resource.aws_security_group.bastion_sg]


  # lifecycle {
  #   ignore_chances = [ami]
  # }
}

resource "aws_eip_association" "bastion_instance_eip" {
  instance_id   = aws_instance.bastion_instance.id
  allocation_id = aws_eip.aid_platform.id
}

