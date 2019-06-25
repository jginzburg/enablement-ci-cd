
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.plugins.sshslaves.*;

domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
gitUsername = System.getenv("GIT_USERNAME") ?: "lab8"
gitPassword = System.getenv("GIT_PASSWORD") ?: "white101"

usernameAndPassword = new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "jenkins-git-creds", "Git creds for Jenkins",
  gitUsername,
  gitPassword
)

store.addCredentials(domain, usernameAndPassword)
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
