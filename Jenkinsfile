pipeline {
    
    agent any
tools {
        maven 'Maven 3.9.5'
        
    }
    stages {
		
        stage('Test') {
            steps {
			withMaven(maven: 'mvn') {
				sh "mvn clean test"
			}
                
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