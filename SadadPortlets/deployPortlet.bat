@echo off
PortalServer\bin

:: set WP_PROFILE=D:\IBM\Portal_80\wp_profile
set WP_PROFILE=D:\IBM\Portal_90\wp_profile
set PATH=%PATH%;%WP_PROFILE%\ConfigEngine;%WP_PROFILE%\bin;%WP_PROFILE%\PortalServer\bin;

set user=wpsadmin
set pass=n0h0p3
set host=localhost
:: set port=10039
set port=10078
set deploy_artifact=.target\SadadPortlets-0.0.1-SNAPSHOT.war

xmlaccess.bat -in deployPortlet.xml -user %user% -password %pass% -out deployPortletResult.xml -url http://%host%:%port%/wps/config

echo "Done"
@echo on
