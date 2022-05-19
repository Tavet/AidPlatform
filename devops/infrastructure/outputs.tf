output "bastion_public_ip" {
  description = "Public IP address of the Bastion instance"
  value       = aws_eip.aid_platform.public_ip
}
