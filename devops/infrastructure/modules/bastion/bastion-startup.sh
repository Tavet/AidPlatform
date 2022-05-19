#/bin/sh

sshuttle -r ubuntu@$BASTION_IP 10.0.0.0/16 --dns  --ssh-cmd 'ssh -i /root/aws-ec2'

curl https://raw.githubusercontent.com/errm/k8s-iam-policies/master/setup.sh -o setup.sh

sh -e setup.sh