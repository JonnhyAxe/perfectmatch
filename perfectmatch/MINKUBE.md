
In order to deploy the app  on a local Kubernetes environment, also known as Minikube, we need the following steps: 

* installing minikube on windows using virtualbox
* Set up the application on a one-node cluster using Minikube

## Installing Minikube

The installation of Minikube basically consists of three steps: installing a Hypervisor (like VirtualBox), the CLI kubectl (an command line tool that allows us to manage and deploy applications on Kubernetes), as well as Minikube itself.

Please use the  [official documentation](https://kubernetes.io/docs/tasks/tools/install-minikube/)  or an [alternative resources](https://www.assistanz.com/installing-minikube-on-windows-10-home-edition-using-virtualbox/) with all steps required  

Open an command line and start it

```
minikube start

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
minikube status
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

## Open dashboard 

```
minikube dashboard 
```

## Configure docker CLI to use Minikube docker deamon


```
minikube docker-env
SET DOCKER_TLS_VERIFY=1
SET DOCKER_HOST=tcp://192.168.99.101:2376
SET DOCKER_CERT_PATH=C:\Users\joao_\.minikube\certs
SET DOCKER_API_VERSION=1.35
REM Run this command to configure your shell:
REM @FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i
```

Next create deployment of our application in the cluster.

```
cd projectpath\backend\minikube
kubectl create -f deployment.yml 
```

We can see description of the service with


```
kubectl describe service spring-boot-mongo-docker
```



Now get the exact address of the service with

```
minikube service spring-boot-mongo-docker 
```


## Deploy the app on Kubernetes

we need to implement a Deployment configuration. 


1 - docker images
2 - sudo kubectl run {DEPLOYMENT_NAME} --image= {YOUR_IMAGE} --port=8080

References: 
* https://itnext.io/migrating-a-spring-boot-service-to-kubernetes-in-5-steps-7c1702da81b6
* https://spring.io/guides/gs/spring-boot-docker/
* https://kubernetes.io/docs/concepts/
* https://kubernetes.io/docs/tutorials/
* https://geeks18.wordpress.com/2018/07/26/deploying-spring-boot-and-mongodb-as-containers-using-kubernetes-and-docker/
* https://www.baeldung.com/spring-boot-minikube
* https://medium.com/nstech/spring-boot-movendo-para-o-kubernetes-b6a6dd25e9f9
* https://www.assistanz.com/installing-minikube-on-windows-10-home-edition-using-virtualbox/
* https://www.baeldung.com/spring-boot-minikube 
* https://medium.com/skillshare-team/from-docker-compose-to-minikube-d94cbe97acda
* https://github.com/nhatthai/spring-mongodb-minikube
* https://piotrminkowski.wordpress.com/2018/08/02/quick-guide-to-microservices-with-kubernetes-spring-boot-2-0-and-docker/
* https://github.com/sivaprasadreddy/spring-boot-k8s-demo
*https://blog.couchbase.com/elastic-microservices-with-kubernetes-and-spring-boot/

