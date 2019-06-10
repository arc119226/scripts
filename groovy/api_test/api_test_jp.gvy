def apis=
['http://10.1.5.64/cmsApi/GetContentArticleListJSON?contentGroupNo=195&serviceCode=PGS020&pageIndex=1&rowPerPage=10&isMainPost=-1&isBannerPost=-1&isLauncherPost=-1',
 'http://10.1.5.59/cmsApi/GetContentArticleListJSON?contentGroupNo=195&serviceCode=PGS020&pageIndex=1&rowPerPage=10&isMainPost=-1&isBannerPost=-1&isLauncherPost=-1',
 'http://10.1.5.60/cmsApi/GetContentArticleListJSON?contentGroupNo=195&serviceCode=PGS020&pageIndex=1&rowPerPage=10&isMainPost=-1&isBannerPost=-1&isLauncherPost=-1',
'http://10.1.5.61/cmsApi/GetContentArticleListJSON?contentGroupNo=195&serviceCode=PGS020&pageIndex=1&rowPerPage=10&isMainPost=-1&isBannerPost=-1&isLauncherPost=-1',
'http://10.1.5.62/cmsApi/GetContentArticleListJSON?contentGroupNo=195&serviceCode=PGS020&pageIndex=1&rowPerPage=10&isMainPost=-1&isBannerPost=-1&isLauncherPost=-1']
def results=new HashMap<String,String>();
apis.each{
	try{
		results.put(new URL(it).getText().trim(),"OK");
		println results.size();
	}catch(e){
		println it
	}
}