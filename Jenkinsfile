pipeline {
    
    agent { 
        node {
            label 'windows'
            }
      }
	tools {
        maven "MAVEN"
        jdk "JDK"
    }
    stages {
		 stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Test') {
            steps {
				bat "mvn clean test"
                
            }
 
            post {                
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'emailable-report.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
}