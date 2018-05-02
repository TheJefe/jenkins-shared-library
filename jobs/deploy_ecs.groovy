node {
    properties([
        parameters([
            choice(name: 'CLUSTER', choices: 'dadjokes', description: 'AWS ECS Cluster for the servcie that you\'d like to deploy'),
            choice(name: 'SERVICE', choices: 'dadjokes', description: 'AWS ECS Cluster service for the service you\'d like to deploy'),
            choice(name: 'REGION', choices: 'us-east-1\nus-west-1\nap-south-1\nca-central-1', description: 'AWS ECS Region to deploy to')
        ])
    ])

    @Library('jenkins-shared-library')
    def ecs = new ecs()
    ecs.deployService(CLUSTER, SERVICE, REGION)
}
