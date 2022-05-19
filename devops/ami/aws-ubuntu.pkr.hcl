packer {
  required_plugins {
    amazon = {
      version = ">= 0.0.2"
      source  = "github.com/hashicorp/amazon"
    }
  }
}

source "amazon-ebs" "bastion" {
  ami_name      = "bastion-aid-platform-dev"
  instance_type = "t2.micro"
  region        = "eu-central-1"
  source_ami_filter {
    filters = {
      name                = "ubuntu/images/*ubuntu-xenial-16.04-amd64-server-*"
      root-device-type    = "ebs"
      virtualization-type = "hvm"
    }
    most_recent = true
    owners      = ["107982701859"]
  }
  ssh_username = "ubuntu"
}

build {
  name    = "bastion"
  sources = [
    "source.amazon-ebs.bastion"
  ]

  provisioner "shell" {
    execute_command  = "echo 'packer' | sudo -S sh -c '{{ .Vars }} {{ .Path }}'"
    script           = "bastion.sh"
  }
}