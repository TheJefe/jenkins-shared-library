def deployService(cluster, service, region){
    env.CLUSTER = cluster
    env.SERVICE = service
    env.REGION = region
    withCredentials([usernamePassword(credentialsId: 'ecs', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
        sh '''#!/bin/bash -l
        aws ecs update-service --force-new-deployment --cluster ${CLUSTER} --service ${SERVICE} --region ${REGION}
        '''
    }
}
return this
