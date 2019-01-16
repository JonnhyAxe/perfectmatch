
In order to deploy the app  on a local Kubernetes environment, also known as Minikube, we need the following steps: 

* installing minikube on windows using virtualbox
* Set up the application on a one-node cluster using Minikube

## Installing Minikube

The installation of Minikube basically consists of three steps: installing a Hypervisor (like VirtualBox), the CLI kubectl, as well as Minikube itself.

Please use the  [official documentation](https://kubernetes.io/docs/tasks/tools/install-minikube/)  or an [alternative resources](https://www.assistanz.com/installing-minikube-on-windows-10-home-edition-using-virtualbox/) with all steps required  

Open an command line and start it

```
minkube start

Starting local Kubernetes v1.10.0 cluster...
Starting VM...
Getting VM IP address...
Moving files into cluster...
Setting up certs...
Connecting to cluster...
Setting up kubeconfig...
Starting cluster components...
Kubectl is now configured to use the cluster.
Loading cached images from config file.

```

Check the status 

```
minkube status
minikube: Running
cluster: Running
kubectl: Correctly Configured: pointing to minikube-vm at 192.168.99.101

kubectl get nodes 
NAME       STATUS   ROLES    AGE   VERSION
minikube   Ready    master   42d   v1.10.0

kubectl cluster-info
Kubernetes master is running at https://192.168.99.101:8443
CoreDNS is running at https://192.168.99.101:8443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

```

Open dashboard 

```
minikube dashboard 
```



References: 

* https://www.assistanz.com/installing-minikube-on-windows-10-home-edition-using-virtualbox/
* https://www.baeldung.com/spring-boot-minikube 