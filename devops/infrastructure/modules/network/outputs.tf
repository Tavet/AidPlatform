output "eip_ip_address" {
  description = "Public IP address of the Bastion instance"
  value       = aws_eip.aid_platform.public_ip
}

output "eip_id" {
  description = "Public IP address ID"
  value       = aws_eip.aid_platform.id
}

output "vpc_id" {
  description = "VPC ID"
  value       = aws_vpc.aid_platform.id
}
