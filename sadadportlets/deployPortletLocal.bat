@echo off
PortalServer\bin

set WP_PROFILE=T:\IBM\Portal_90\wp_profile
set PATH=%PATH%;%WP_PROFILE%\ConfigEngine;%WP_PROFILE%\bin;%WP_PROFILE%\PortalServer\bin;

set user=wpsadmin
set pass=n0h0p3
set host=localhost
set port=10039
set deploy_artifact=.target\SadadEBPPPortal_SadadPortlets.war

xmlaccess.bat -in deployPortlet.xml -user %user% -password %pass% -out deployPortletResult.xml -url http://%host%:%port%/wps/config

echo "Done"
@echo on