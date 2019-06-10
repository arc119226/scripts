def apis=
[
'http://10.1.5.13/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.73/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.74/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.75/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.76/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.78/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.79/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.80/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index',
'http://10.1.5.81/cmsApi/GetContentArticleListJSON?contentGroupNo=7&serviceCode=SVR001&pageIndex=1&rowPerPage=20&rowPerIndex=100&keyword=index'
]
def results=new HashMap<String,String>();
apis.each{
	try{
		results.put(new URL(it).getText().trim(),"OK");
		println "api:"+(results.size()==1);
	}catch(e){
		println it
	}
}
def webs=
[//begin 7 end 14
'http://10.1.5.4/JointActivities/goldMedalPrediction/index',
'http://10.1.2.12/JointActivities/goldMedalPrediction/index',
'http://10.1.2.13/JointActivities/goldMedalPrediction/index',
'http://10.1.2.15/JointActivities/goldMedalPrediction/index',
'http://10.1.2.16/JointActivities/goldMedalPrediction/index',
'http://10.1.2.25/JointActivities/goldMedalPrediction/index',
'http://10.1.2.23/JointActivities/goldMedalPrediction/index',
'http://10.1.2.24/JointActivities/goldMedalPrediction/index',
'http://10.1.2.26/JointActivities/goldMedalPrediction/index',
'http://10.1.2.27/JointActivities/goldMedalPrediction/index'
]
def web_results=new HashMap<String,String>();
webs.each{
	try{
		web_results.put(new URL(it).getText().trim(),"OK");
		println "front:"+(web_results.size()==1)+':'+web_results.size();
	}catch(e){
		println it
	}
}
