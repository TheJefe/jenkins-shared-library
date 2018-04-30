def deployService(cluster, service){
    env.CLUSTER = cluster
    env.SERVICE = service
    sh '''#!/bin/bash -l
    aws ecs update-service --force-new-deployment --cluster ${CLUSTER} --service ${SERVICE}
    '''
}
return this
