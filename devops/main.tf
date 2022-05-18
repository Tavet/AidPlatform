terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "eu-central-1"
}

resource "aws_vpc" "aid_platform" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
  tags = {
    Name                                = "aidplatform_vpc"
    Project                             = "AidPlatform"
    "kubernetes.io/cluster/aidplatform" = "shared"
  }
}

resource "aws_subnet" "aid_platform_private" {
  vpc_id            = aws_vpc.aid_platform.id
  cidr_block        = "10.0.0.0/24"
  availability_zone = "eu-central-1b"

  tags = {
    Name                                = "aidplatform-private-1b"
    Project                             = "AidPlatform"
    "kubernetes.io/cluster/aidplatform" = "owned"
    "kubernetes.io/role/internal-elb"   = "1"
  }
}


resource "aws_subnet" "aid_platform_public" {
  vpc_id            = aws_vpc.aid_platform.id
  cidr_block        = "10.0.16.0/24"
  availability_zone = "eu-central-1b"

  tags = {
    Name                                = "aidplatform-public-1b"
    Project                             = "AidPlatform"
    "kubernetes.io/cluster/aidplatform" = "owned"
    "kubernetes.io/role/internal-elb"   = "1"
  }
}

resource "aws_route_table" "aid_platform" {
  vpc_id = aws_vpc.aid_platform.id
  route  = []
  tags = {
    Name    = "aidplatform_routetable"
    Project = "AidPlatform"
  }
}

resource "aws_route_table_association" "aid_platform_public" {
  subnet_id      = aws_subnet.aid_platform_public.id
  route_table_id = aws_route_table.aid_platform.id
}