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
  region  = var.region
}

module "network" {
  source            = "./modules/network"
  availability_zone = var.availability_zone
}


module "bastion" {
  source            = "./modules/bastion"
  availability_zone = var.availability_zone
  eip_ip_address    = module.network.eip_ip_address
  eip_id            = module.network.eip_id
  vpc_id            = module.network.vpc_id
}
