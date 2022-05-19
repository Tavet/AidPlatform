// VPC
resource "aws_vpc" "aid_platform" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
  tags = {
    Name                                = "aidplatform-vpc"
    Project                             = "AidPlatform"
    "kubernetes.io/cluster/aidplatform" = "shared"
  }
}

resource "aws_subnet" "aid_platform_private" {
  vpc_id            = aws_vpc.aid_platform.id
  cidr_block        = "10.0.0.0/24"
  availability_zone = var.availability_zone

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
  availability_zone = var.availability_zone

  tags = {
    Name                                = "aidplatform-public-1b"
    Project                             = "AidPlatform"
    "kubernetes.io/cluster/aidplatform" = "owned"
    "kubernetes.io/role/internal-elb"   = "1"
  }
}

// Internet gateway
resource "aws_internet_gateway" "aid_platform_gw" {
  vpc_id = aws_vpc.aid_platform.id

  tags = {
    Name    = "aidplatform-igw"
    Project = "AidPlatform"
  }
}

// Default Route Table
resource "aws_default_route_table" "aid_platform" {
  default_route_table_id = aws_vpc.aid_platform.default_route_table_id

  route {
    cidr_block     = "0.0.0.0/0"
    nat_gateway_id = aws_nat_gateway.aid_platform.id
  }

  tags = {
    Name    = "aidplatform-default-rt"
    Project = "AidPlatform"
  }

  depends_on = [aws_nat_gateway.aid_platform]
}

// Public Route table
resource "aws_route_table" "aid_platform" {
  vpc_id = aws_vpc.aid_platform.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.aid_platform_gw.id
  }
  tags = {
    Name    = "aidplatform-rt"
    Project = "AidPlatform"
  }

  depends_on = [aws_internet_gateway.aid_platform_gw]
}

resource "aws_route_table_association" "aid_platform_public" {
  subnet_id      = aws_subnet.aid_platform_public.id
  route_table_id = aws_route_table.aid_platform.id
}

// EIP
resource "aws_eip" "aid_platform" {
  vpc = true
}

// NAT
resource "aws_nat_gateway" "aid_platform" {
  allocation_id = aws_eip.aid_platform.id
  subnet_id     = aws_subnet.aid_platform_public.id

  tags = {
    Name    = "aidplatform-ngw"
    Project = "AidPlatform"
  }

  depends_on = [aws_internet_gateway.aid_platform_gw]
}
