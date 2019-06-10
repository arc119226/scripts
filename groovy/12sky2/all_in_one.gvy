@Grapes(
    [
    	@Grab(group='net.sourceforge.jtds', module='jtds', version='1.3.1')
    ]
)
@GrabConfig(systemClassLoader=true)

import groovy.sql.Sql

//set game item code 
String itemCode='8600'
//is multiItem in one solt
boolean isMultiItem=true

//connect to 12sky2 live
def user='ts2dbuser'
def pass='b!%wtsrh'
def jdbc='jdbc:jtds:sqlserver://10.1.4.2:1433;databaseName=GAME2_01'
def jdbcDriver='net.sourceforge.jtds.jdbc.Driver'

String extractItemCode=itemCode.padLeft(5, '0')
//clean all
println new File("${itemCode}_aUngyechunsang.txt").delete();
println new File("${itemCode}_aPatBag.txt").delete();
println new File("${itemCode}_avatarInfo.txt").delete();
println new File("${itemCode}_masterInfo.txt").delete();
println new File('avatarInfo.txt').delete();
println new File('masterInfo.txt').delete();
println 'find item:'+itemCode
println extractItemCode
println isMultiItem

def _aUngyechunsangSql =
"""
-- aUngyechunsang
select 
	uID,aName,
	(case aUngyechunsang01 when ${itemCode} then 1 else 0 end + case aUngyechunsang02 when ${itemCode} then 1 else 0 end +
	case aUngyechunsang03 when ${itemCode} then 1 else 0 end + case aUngyechunsang04 when ${itemCode} then 1 else 0 end +
	case aUngyechunsang05 when ${itemCode} then 1 else 0 end + case aUngyechunsang06 when ${itemCode} then 1 else 0 end +
	case aUngyechunsang07 when ${itemCode} then 1 else 0 end + case aUngyechunsang08 when ${itemCode} then 1 else 0 end +
	case aUngyechunsang09 when ${itemCode} then 1 else 0 end + case aUngyechunsang10 when ${itemCode} then 1 else 0 end 
	) as aUngyechunsangCount
from dbo.AvatarInfo2
where (aUngyechunsang01 in (${itemCode})) or (aUngyechunsang02 in (${itemCode})) or (aUngyechunsang03 in (${itemCode})) or
      (aUngyechunsang04 in (${itemCode})) or (aUngyechunsang06 in (${itemCode})) or (aUngyechunsang08 in (${itemCode})) or
      (aUngyechunsang09 in (${itemCode})) or (aUngyechunsang10 in (${itemCode}))

"""
println 'find aUngyechunsang start'
new FileOutputStream(itemCode+'_aUngyechunsangCount.txt').withWriter('UTF-8') { writer ->
	def sql = Sql.newInstance(jdbc,user,pass,jdbcDriver)
 	sql.eachRow(_aUngyechunsangSql){ 
 		writer << "${it.uID},${it.aName},${it.aUngyechunsangCount}\r\n";
	}
	sql.close();
}
println 'find aUngyechunsang end'
def _aPatBagSql=
"""
-- aPatBag
select 
	uID,aName,
	(case aPatBag01 when ${itemCode} then 1 else 0 end + case aPatBag02 when ${itemCode} then 1 else 0 end +
	case aPatBag03 when ${itemCode} then 1 else 0 end + case aPatBag04 when ${itemCode} then 1 else 0 end +
	case aPatBag05 when ${itemCode} then 1 else 0 end + case aPatBag06 when ${itemCode} then 1 else 0 end +
	case aPatBag07 when ${itemCode} then 1 else 0 end + case aPatBag08 when ${itemCode} then 1 else 0 end +
	case aPatBag09 when ${itemCode} then 1 else 0 end + case aPatBag10 when ${itemCode} then 1 else 0 end +
	case aPatBag11 when ${itemCode} then 1 else 0 end + case aPatBag12 when ${itemCode} then 1 else 0 end +
	case aPatBag13 when ${itemCode} then 1 else 0 end + case aPatBag14 when ${itemCode} then 1 else 0 end +
	case aPatBag15 when ${itemCode} then 1 else 0 end + case aPatBag16 when ${itemCode} then 1 else 0 end +
	case aPatBag17 when ${itemCode} then 1 else 0 end + case aPatBag18 when ${itemCode} then 1 else 0 end +
	case aPatBag19 when ${itemCode} then 1 else 0 end + case aPatBag20 when ${itemCode} then 1 else 0 end) as aPatBagCount
from dbo.AvatarInfo2
where (aPatBag01 in (${itemCode})) or (aPatBag02 in (${itemCode})) or (aPatBag03 in (${itemCode})) or
      (aPatBag04 in (${itemCode})) or (aPatBag06 in (${itemCode})) or (aPatBag08 in (${itemCode})) or
      (aPatBag09 in (${itemCode})) or (aPatBag10 in (${itemCode})) or (aPatBag11 in (${itemCode})) or
      (aPatBag12 in (${itemCode})) or (aPatBag13 in (${itemCode})) or (aPatBag14 in (${itemCode})) or
      (aPatBag15 in (${itemCode})) or (aPatBag16 in (${itemCode})) or (aPatBag17 in (${itemCode})) or
      (aPatBag18 in (${itemCode})) or (aPatBag19 in (${itemCode})) or (aPatBag20 in (${itemCode}))
"""
println 'find aPatBag start'
new FileOutputStream(itemCode+'_aPatBag.txt').withWriter('UTF-8') { writer ->
	def sql = Sql.newInstance(jdbc,user,pass,jdbcDriver)
 	sql.eachRow(_aPatBagSql){ 
 		writer << "${it.uID},${it.aName},${it.aPatBagCount}\r\n";
	}
	sql.close();
}
println 'find aPatBag end'
println 'query role start'
int allLine=0
def current=0
def _count_avatarInfoSql='select count(1) cnt from dbo.AvatarInfo'
def _avatarInfoSql='select uID,aName,aInventory,aStoreItem,aTrade from dbo.AvatarInfo'
Sql.newInstance(jdbc,user,pass,jdbcDriver).eachRow(_count_avatarInfoSql){allLine=it.cnt}
println allLine
new FileOutputStream('avatarInfo.txt').withWriter('UTF-8') { writer ->
	def sql = Sql.newInstance(jdbc,user,pass,jdbcDriver)
 	int i=0
 	sql.eachRow(_avatarInfoSql){	
 		writer << "${it.uID},${it.aName},${it.aInventory},${it.aStoreItem},${it.aTrade}\r\n"
		i++;
		def percent= i/allLine*100
		def result=new java.math.BigDecimal(percent).setScale(-1, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(result>current){
			current=result
			print ">";
		}
	}
	sql.close();
}
println ''
println 'query role end'
println 'analysis role start'

current=0
new FileOutputStream(itemCode+'_avatarInfo.txt').withWriter('UTF-8') { writer ->
	int i=0
	def reader = new File('avatarInfo.txt').newReader('UTF-8')
	reader.eachLine { line ->
		def uID= line.split(',')[0]
		def aName =line.split(',')[1]
		def aInventory =line.split(',')[2]
		def aStoreItem =line.split(',')[3]
		def aTrade =line.split(',')[4]
		def maxaInventoryItems = aInventory.length()/27;
		def maxaStoreItems = aStoreItem.length()/25;
		def mxaaTradeItems = aTrade.length()/25;

		int inventoryitem =0;
		for(int index=0;index<maxaInventoryItems;index++){
			if(aInventory.substring((int)(index*27),(int)((index+1)*27)).startsWith(extractItemCode)){
				def c=Integer.parseInt((aInventory.substring((int)(index*27),(int)((index+1)*27)).substring(8,10)))
				if(isMultiItem){
					inventoryitem+=c;
				}else{
					inventoryitem+=1
				}
			}
		}
		int storeItemitem =0;
		for(int index=0;index<maxaStoreItems;index++){
			if(aStoreItem.substring((int)(index*25),(int)((index+1)*25)).startsWith(extractItemCode)){
				def c= Integer.parseInt(aStoreItem.substring((int)(index*25),(int)((index+1)*25)).substring(6,8));
				if(isMultiItem){
					storeItemitem+=c;
				}else{
					storeItemitem+=1
				}
			}
		}
		int aTradeItemitem =0;
		for(int index=0;index<mxaaTradeItems;index++){
			if(aTrade.substring((int)(index*25),(int)((index+1)*25)).startsWith(extractItemCode)){
				def c=Integer.parseInt(aTrade.substring((int)(index*25),(int)((index+1)*25)).substring(6,8));
				if(isMultiItem){
					aTradeItemitem+=c;
				}else{
					aTradeItemitem+=1
				}
			}
		}
		if(inventoryitem>0||storeItemitem>0||aTradeItemitem>0){
			writer <<  "${uID}\t${aName}\t${inventoryitem}\t${storeItemitem}\t${aTradeItemitem}\r\n"
		}
		i++;
		def percent= i/allLine*100
		def result=new java.math.BigDecimal(percent).setScale(-1, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(result>current){
			current=result
			print ">";
		}
	}
}
println ''
println 'analysis role end'
println 'query warehouse start'
def _count_msterInfoSql='select count(1) cnt from dbo.MasterInfo'
def _msterInfosql='select uID,aName01,aName02,aName03,uSaveItem from dbo.MasterInfo'
Sql.newInstance(jdbc,user,pass,jdbcDriver).eachRow(_count_msterInfoSql){allLine=it.cnt}
println allLine
current=0
new FileOutputStream('masterInfo.txt').withWriter('UTF-8') { writer ->
	def sql = Sql.newInstance(jdbc,user,pass,jdbcDriver)
 	int i=0
 	sql.eachRow(_msterInfosql){ 
 		writer << "${it.uID},${it.aName01},${it.aName02},${it.aName03},${it.uSaveItem}\r\n"
		i++;
		def percent= i/allLine*100
		def result=new java.math.BigDecimal(percent).setScale(-1, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(result>current){
			current=result
			print ">";
		}
	}
	sql.close();
}
println ''
println 'query warehouse end'
println 'analysis warehouse start'
current=0
new FileOutputStream(itemCode+'_masterInfo.txt').withWriter('UTF-8') { writer ->
	int i=0
	def reader = new File('masterInfo.txt').newReader('UTF-8')
	reader.eachLine { line ->
		def uID= line.split(',')[0]
		def aName01 =line.split(',')[1]
		def aName02 =line.split(',')[2]
		def aName03 =line.split(',')[3]
		def uSaveItem =line.split(',')[4]
		def maxuSaveItems = uSaveItem.length()/25;
		def uSaveItems =0;
		for(int index=0;index<maxuSaveItems;index++){
			if(uSaveItem.substring((int)(index*25),(int)((index+1)*25)).startsWith(extractItemCode)){
				def c=Integer.parseInt(uSaveItem.substring((int)(index*25),(int)((index+1)*25)).substring(6,8))
				uSaveItems+=c;
				if(isMultiItem){
					uSaveItems+=c;
				}else{
					uSaveItems+=1
				}
			}
		}
		if(uSaveItems>0){
			writer << "${uID}\t${aName01}\t${aName02}\t${aName03}\t${uSaveItems}\r\n"
		}
		i++;
		def percent= i/allLine*100
		def result=new java.math.BigDecimal(percent).setScale(-1, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		if(result>current){
			current=result
			print ">";
		}
	}
}
println ''
println 'analysis warehouse end'