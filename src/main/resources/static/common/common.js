/**
 * js common
 * Created by hefule on 2016/8/4.
 */
//projectName
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName); //获取主机地址
var localhostPaht=curWwwPath.substring(0,pos); //获取带"/"的项目名，如：/uimcardprj
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var rootPath = localhostPaht+projectName;
//ie
var userAgent = navigator.userAgent;
var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1;
if(isIE){
    var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
    reIE.test(userAgent);
    var fIEVersion = parseFloat(RegExp["$1"]);
    if(fIEVersion==7.0){
        document.write('<link type="text/css" href="'+rootPath+'//jqueryUiBootstrap/assets/css/font-awesome-ie7.min.css" rel="stylesheet" />');
    }else if(fIEVersion<=9.0){
        document.write('<link type="text/css" href="'+rootPath+'//jqueryUiBootstrap/css/custom-theme/jquery.ui.1.10.0.ie.css" rel="stylesheet" />');
    }
    if(fIEVersion<=9.0){
        document.write('<script type="text/javascript" src="'+rootPath+'//jqueryUiBootstrap/js/html5.js"></script>');
    }
}
//css
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />');
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />');
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/assets/css/font-awesome.min.css" rel="stylesheet" />');
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/assets/css/docs.css" rel="stylesheet" />');
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet" />');
document.write('<link type="text/css" href="'+rootPath+'/jqueryUiBootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />');
//icon
document.write('<link rel="apple-touch-icon-precomposed" sizes="144x144" href="'+rootPath+'/jqueryUiBootstrap/assets/ico/apple-touch-icon-144-precomposed.png" />');
document.write('<link rel="apple-touch-icon-precomposed" sizes="114x114" href="'+rootPath+'/jqueryUiBootstrap/assets/ico/apple-touch-icon-114-precomposed.png" />');
document.write('<link rel="apple-touch-icon-precomposed" sizes="72x72" href="'+rootPath+'/jqueryUiBootstrap/assets/ico/apple-touch-icon-72-precomposed.png" />');
document.write('<link rel="apple-touch-icon-precomposed" href="'+rootPath+'//jqueryUiBootstrap/assets/ico/apple-touch-icon-57-precomposed.png" />');
document.write('<link rel="shortcut icon" href="'+rootPath+'/jqueryUiBootstrap/assets/ico/favicon.png" />');
//js
document.write('<script type="text/javascript" src="'+rootPath+'/jquery/jquery-1.12.4.min.js"></script>');
document.write('<script type="text/javascript" src="'+rootPath+'/jqueryUiBootstrap/assets/js/bootstrap.min.js"></script>');
document.write('<script type="text/javascript" src="'+rootPath+'/jqueryUiBootstrap/assets/js/jquery-ui-1.10.0.custom.min.js"></script>');
document.write('<script type="text/javascript" src="'+rootPath+'/jqueryUiBootstrap/assets/js/google-code-prettify/prettify.js"></script>');
document.write('<script type="text/javascript" src="'+rootPath+'/jqueryUiBootstrap/assets/js/docs.js"></script>');
document.write('<script type="text/javascript" src="'+rootPath+'/jqueryUiBootstrap/assets/js/demo.js"></script>');

