#/bin/sh

sshuttle -r ubuntu@$BASTION_IP 10.0.0.0/16 --dns  --ssh-cmd 'ssh -i /root/aws-ec2'