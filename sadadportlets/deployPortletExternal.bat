@echo off

set KITTY_PATH=D:\SoftwareUtils\kitty;
set PATH=%Kitty_Path%;%PATH%

set DEPLOYMENT_HOME=/home/wasadmin/Deployments
set BAR_DIRECTORY=%~dp0
set USER=wasadmin
set PSWD=wasadmin*
set KEY=D:\SoftwareUtils\kitty\.ssh\identity.ppk
set HOST=10.32.33.11

:: Clear the Old BAR file
klink -i %KEY% %USER%@%HOST% %DEPLOYMENT_HOME%/scripts/cleanupDeployments.sh

:: Copying the new BAR files to the server
kscp -i %key% D:/SADAD_Dev/Workspaces/S2/Portal_POC/SadadPortlets/target/SadadPortlets-*.war %USER%@%HOST%:%DEPLOYMENT_HOME%/artifacts/

:: Executing it for Deployment
klink -i %key% %USER%@%HOST% %DEPLOYMENT_HOME%/scripts/deploy.sh

echo Process terminated.

@echo on