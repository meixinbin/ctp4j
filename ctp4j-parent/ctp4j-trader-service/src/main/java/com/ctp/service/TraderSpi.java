package com.ctp.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.trader.dao.InvestorPositionDao;
import com.ctp.trader.dao.InvestorPositionDetailDao;
import com.ctp.trader.dao.OrderDao;
import com.ctp.trader.dao.TradeDao;
import com.ctp.trader.dao.TradingAccountDao;
import com.ctp.trader.dto.InstrumentDTO;
import com.ctp.trader.entity.InvestorPosition;
import com.ctp.trader.entity.InvestorPositionDetail;
import com.ctp.trader.entity.Order;
import com.ctp.trader.entity.Trade;
import com.ctp.trader.entity.TradingAccount;
import com.ctp.trader.service.InstrumentService;
import com.ctp.trader.service.TraderApiTriggerService;
import com.itqy8.ctp.CThostFtdcAccountregisterField;
import com.itqy8.ctp.CThostFtdcBrokerTradingAlgosField;
import com.itqy8.ctp.CThostFtdcBrokerTradingParamsField;
import com.itqy8.ctp.CThostFtdcCFMMCTradingAccountKeyField;
import com.itqy8.ctp.CThostFtdcCFMMCTradingAccountTokenField;
import com.itqy8.ctp.CThostFtdcCancelAccountField;
import com.itqy8.ctp.CThostFtdcChangeAccountField;
import com.itqy8.ctp.CThostFtdcCombActionField;
import com.itqy8.ctp.CThostFtdcCombInstrumentGuardField;
import com.itqy8.ctp.CThostFtdcContractBankField;
import com.itqy8.ctp.CThostFtdcDepthMarketDataField;
import com.itqy8.ctp.CThostFtdcEWarrantOffsetField;
import com.itqy8.ctp.CThostFtdcErrorConditionalOrderField;
import com.itqy8.ctp.CThostFtdcExchangeField;
import com.itqy8.ctp.CThostFtdcExchangeMarginRateAdjustField;
import com.itqy8.ctp.CThostFtdcExchangeMarginRateField;
import com.itqy8.ctp.CThostFtdcExchangeRateField;
import com.itqy8.ctp.CThostFtdcExecOrderActionField;
import com.itqy8.ctp.CThostFtdcExecOrderField;
import com.itqy8.ctp.CThostFtdcForQuoteField;
import com.itqy8.ctp.CThostFtdcForQuoteRspField;
import com.itqy8.ctp.CThostFtdcInputCombActionField;
import com.itqy8.ctp.CThostFtdcInputExecOrderActionField;
import com.itqy8.ctp.CThostFtdcInputExecOrderField;
import com.itqy8.ctp.CThostFtdcInputForQuoteField;
import com.itqy8.ctp.CThostFtdcInputOrderActionField;
import com.itqy8.ctp.CThostFtdcInputOrderField;
import com.itqy8.ctp.CThostFtdcInputQuoteActionField;
import com.itqy8.ctp.CThostFtdcInputQuoteField;
import com.itqy8.ctp.CThostFtdcInstrumentCommissionRateField;
import com.itqy8.ctp.CThostFtdcInstrumentField;
import com.itqy8.ctp.CThostFtdcInstrumentMarginRateField;
import com.itqy8.ctp.CThostFtdcInstrumentStatusField;
import com.itqy8.ctp.CThostFtdcInvestorField;
import com.itqy8.ctp.CThostFtdcInvestorPositionCombineDetailField;
import com.itqy8.ctp.CThostFtdcInvestorPositionDetailField;
import com.itqy8.ctp.CThostFtdcInvestorPositionField;
import com.itqy8.ctp.CThostFtdcInvestorProductGroupMarginField;
import com.itqy8.ctp.CThostFtdcNoticeField;
import com.itqy8.ctp.CThostFtdcNotifyQueryAccountField;
import com.itqy8.ctp.CThostFtdcOpenAccountField;
import com.itqy8.ctp.CThostFtdcOptionInstrCommRateField;
import com.itqy8.ctp.CThostFtdcOptionInstrTradeCostField;
import com.itqy8.ctp.CThostFtdcOrderActionField;
import com.itqy8.ctp.CThostFtdcOrderField;
import com.itqy8.ctp.CThostFtdcParkedOrderActionField;
import com.itqy8.ctp.CThostFtdcParkedOrderField;
import com.itqy8.ctp.CThostFtdcProductExchRateField;
import com.itqy8.ctp.CThostFtdcProductField;
import com.itqy8.ctp.CThostFtdcQryInstrumentField;
import com.itqy8.ctp.CThostFtdcQueryCFMMCTradingAccountTokenField;
import com.itqy8.ctp.CThostFtdcQueryMaxOrderVolumeField;
import com.itqy8.ctp.CThostFtdcQuoteActionField;
import com.itqy8.ctp.CThostFtdcQuoteField;
import com.itqy8.ctp.CThostFtdcRemoveParkedOrderActionField;
import com.itqy8.ctp.CThostFtdcRemoveParkedOrderField;
import com.itqy8.ctp.CThostFtdcReqAuthenticateField;
import com.itqy8.ctp.CThostFtdcReqQueryAccountField;
import com.itqy8.ctp.CThostFtdcReqRepealField;
import com.itqy8.ctp.CThostFtdcReqTransferField;
import com.itqy8.ctp.CThostFtdcReqUserLoginField;
import com.itqy8.ctp.CThostFtdcRspAuthenticateField;
import com.itqy8.ctp.CThostFtdcRspInfoField;
import com.itqy8.ctp.CThostFtdcRspRepealField;
import com.itqy8.ctp.CThostFtdcRspTransferField;
import com.itqy8.ctp.CThostFtdcRspUserLoginField;
import com.itqy8.ctp.CThostFtdcSecAgentACIDMapField;
import com.itqy8.ctp.CThostFtdcSettlementInfoConfirmField;
import com.itqy8.ctp.CThostFtdcSettlementInfoField;
import com.itqy8.ctp.CThostFtdcTradeField;
import com.itqy8.ctp.CThostFtdcTraderApi;
import com.itqy8.ctp.CThostFtdcTraderSpi;
import com.itqy8.ctp.CThostFtdcTradingAccountField;
import com.itqy8.ctp.CThostFtdcTradingAccountPasswordUpdateField;
import com.itqy8.ctp.CThostFtdcTradingCodeField;
import com.itqy8.ctp.CThostFtdcTradingNoticeField;
import com.itqy8.ctp.CThostFtdcTradingNoticeInfoField;
import com.itqy8.ctp.CThostFtdcTransferBankField;
import com.itqy8.ctp.CThostFtdcTransferSerialField;
import com.itqy8.ctp.CThostFtdcUserLogoutField;
import com.itqy8.ctp.CThostFtdcUserPasswordUpdateField;
import com.itqy8.framework.util.SpringPropertyResourceReader;
import com.itqy8.framework.util.SpringUtil;
import com.itqy8.sequence.service.SequenceService;

public class TraderSpi extends CThostFtdcTraderSpi{

//	private Logger log = LoggerFactory.getLogger(TraderSpi.class);
	
	private InstrumentService instrumentService;
	
	private CThostFtdcTraderApi traderApi;
	
	private TradingAccountDao tradingAccountDao;
	private InvestorPositionDao investorPositionDao;
	private InvestorPositionDetailDao investorPositionDetailDao;
	private SequenceService sequenceService;
	private TraderApiTriggerService traderApiTriggerService;
	private int frontID = 0;
	private int sessionID = 0;
	private OrderDao orderDao;
	private TradeDao tradeDao;
	
	public TraderSpi(CThostFtdcTraderApi traderApi){
		this.instrumentService = (InstrumentService) SpringUtil.getBean("instrumentService");
		this.tradingAccountDao = (TradingAccountDao) SpringUtil.getBean("tradingAccountDao");
		this.sequenceService = (SequenceService) SpringUtil.getBean("sequenceService");
		this.traderApiTriggerService = (TraderApiTriggerService) SpringUtil.getBean("traderApiTriggerService");
		this.investorPositionDetailDao = (InvestorPositionDetailDao) SpringUtil.getBean("investorPositionDetailDao");
		this.investorPositionDao = (InvestorPositionDao) SpringUtil.getBean("investorPositionDao");
		this.orderDao = (OrderDao) SpringUtil.getBean("orderDao");
		this.tradeDao = (TradeDao) SpringUtil.getBean("tradeDao");
		this.traderApi = traderApi;
	}
	
	/**
	 * 查询接口有限制,每秒钟只能调用一次
	 * 在这里启动的时候进行初始化
	 * 
	 * @author meixinbin 2016-6-16 上午8:40:35
	 */
	public void init(){
		String brokerID = SpringPropertyResourceReader.getProperty("ctp.brokerId");
		String investorID = SpringPropertyResourceReader.getProperty("ctp.userid");
		String[] ins = {"rb1610"};
		try {
			for(String instrumentID:ins){
				//查询交易账户信息
				this.traderApiTriggerService.qryTradingAccount(brokerID, investorID);
				Thread.sleep(3000);//暂停3秒钟
				//查询用户持仓
				this.traderApiTriggerService.qryInvestorPosition(brokerID, instrumentID, investorID);
				Thread.sleep(3000);//暂停3秒钟
				this.traderApiTriggerService.qryInvestorPositionDetail(brokerID, instrumentID, investorID);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void finalize() {
		super.finalize();
	}

	@Override
	public synchronized void delete() {
		super.delete();
	}

	@Override
	protected void swigDirectorDisconnect() {
		super.swigDirectorDisconnect();
	}

	@Override
	public void swigReleaseOwnership() {
		super.swigReleaseOwnership();
	}

	@Override
	public void swigTakeOwnership() {
		super.swigTakeOwnership();
	}

	@Override
	public void OnFrontConnected() {
		System.out.println("交易前置已连接");
		String brokerid = SpringPropertyResourceReader.getProperty("ctp.brokerId");
		String password = SpringPropertyResourceReader.getProperty("ctp.password");
		String userid = SpringPropertyResourceReader.getProperty("ctp.userid");
		//是否需要认证
		String needAuth = SpringPropertyResourceReader.getProperty("ctp.needAuthenticate");
		if("true".equals(needAuth)){
			CThostFtdcReqAuthenticateField pReqAuthenticateField = new CThostFtdcReqAuthenticateField();
			pReqAuthenticateField.setAuthCode("");
			pReqAuthenticateField.setBrokerID(brokerid);
			pReqAuthenticateField.setUserID(userid);
			pReqAuthenticateField.setUserProductInfo("SFITTraderV100");
			this.traderApi.ReqAuthenticate(pReqAuthenticateField, 1);
		}else{//不需要认证，请求登录
			CThostFtdcReqUserLoginField pReqUserLoginField = new CThostFtdcReqUserLoginField();
			pReqUserLoginField.setBrokerID(brokerid);
			pReqUserLoginField.setPassword(password);
			pReqUserLoginField.setUserID(userid);
			pReqUserLoginField.setUserProductInfo("SFITTraderV100");
			pReqUserLoginField.setInterfaceProductInfo("");
			pReqUserLoginField.setProtocolInfo("");
			this.traderApi.ReqUserLogin(pReqUserLoginField, 1);
		}
		
		
	}

	@Override
	public void OnFrontDisconnected(int nReason) {
		System.out.println("交易前置连接断开");
	}

	@Override
	public void OnHeartBeatWarning(int nTimeLapse) {
		super.OnHeartBeatWarning(nTimeLapse);
	}

	@Override
	public void OnRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("============================OnRspAuthenticate================================");
		CThostFtdcReqUserLoginField pReqUserLoginField = new CThostFtdcReqUserLoginField();
		pReqUserLoginField.setBrokerID("9999");
		pReqUserLoginField.setPassword("MEIxinbin666666");
		pReqUserLoginField.setUserID("057794");
		pReqUserLoginField.setUserProductInfo("SFITTraderV100");
		pReqUserLoginField.setInterfaceProductInfo("");
		pReqUserLoginField.setProtocolInfo("");
		this.traderApi.ReqUserLogin(pReqUserLoginField, 1);
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		//成功登录
		if(pRspInfo.getErrorID()==0){
			System.out.println("登录成功");
			//查询所有合约
			try {
				Thread.sleep(2000);
				CThostFtdcQryInstrumentField pQryInstrument = new CThostFtdcQryInstrumentField();
				this.traderApi.ReqQryInstrument(pQryInstrument, nRequestID);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.frontID = pRspUserLogin.getFrontID();
		this.sessionID = pRspUserLogin.getSessionID();
		//投资者结算结果确认
		CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm = new CThostFtdcSettlementInfoConfirmField();
		pSettlementInfoConfirm.setBrokerID(pRspUserLogin.getBrokerID());
		pSettlementInfoConfirm.setInvestorID(pRspUserLogin.getUserID());
		pSettlementInfoConfirm.setConfirmDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		pSettlementInfoConfirm.setConfirmTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		int sc = this.traderApi.ReqSettlementInfoConfirm(pSettlementInfoConfirm, 1);
		System.out.println("确认结算返回："+sc);
	}

	@Override
	public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("====================OnRspUserLogout=======================");
	}

	@Override
	public void OnRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("======================OnRspUserPasswordUpdate====================");
	}

	@Override
	public void OnRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("======================OnRspTradingAccountPasswordUpdate====================");
	}

	@Override
	public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("==========================OnRspOrderInsert=============================");
		System.out.println(pRspInfo.getErrorID());
	}

	@Override
	public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspParkedOrderInsert(pParkedOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspParkedOrderAction(pParkedOrderAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspOrderAction(CThostFtdcInputOrderActionField pInputOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("========================OnRspOrderAction=========================");
	}

	@Override
	public void OnRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQueryMaxOrderVolume(pQueryMaxOrderVolume, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("========================投资者结算结果确认=====================================");
	}

	@Override
	public void OnRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField pRemoveParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspRemoveParkedOrder(pRemoveParkedOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspRemoveParkedOrderAction(pRemoveParkedOrderAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspExecOrderInsert(pInputExecOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspExecOrderAction(CThostFtdcInputExecOrderActionField pInputExecOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspExecOrderAction(pInputExecOrderAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspForQuoteInsert(pInputForQuote, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQuoteInsert(pInputQuote, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQuoteAction(CThostFtdcInputQuoteActionField pInputQuoteAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQuoteAction(pInputQuoteAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspCombActionInsert(CThostFtdcInputCombActionField pInputCombAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspCombActionInsert(pInputCombAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryOrder(CThostFtdcOrderField pOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryOrder(pOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryTrade(CThostFtdcTradeField pTrade, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryTrade(pTrade, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInvestorPosition(CThostFtdcInvestorPositionField pInvestorPosition, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("=================================OnRspQryInvestorPosition===============================");
		InvestorPosition ip = this.investorPositionDao.getInvestorPosition(pInvestorPosition.getBrokerID(), pInvestorPosition.getInstrumentID(), pInvestorPosition.getInvestorID(), pInvestorPosition.getPosiDirection(), pInvestorPosition.getPositionDate());
		if(ip==null){
			ip = new InvestorPosition();
			ip.setId(this.sequenceService.generate(InvestorPosition.class.getName()).getResult());
		}
		
		ip.setAbandonFrozen(pInvestorPosition.getAbandonFrozen());
		ip.setBrokerID(pInvestorPosition.getBrokerID());
		ip.setCashIn(pInvestorPosition.getCashIn());
		ip.setCloseAmount(pInvestorPosition.getCloseAmount());
		ip.setCloseProfit(pInvestorPosition.getCloseProfit());
		ip.setCloseProfitByDate(pInvestorPosition.getCloseProfitByDate());
		ip.setCloseProfitByTrade(pInvestorPosition.getCloseProfitByTrade());
		ip.setCloseVolume(pInvestorPosition.getCloseVolume());
		ip.setCombLongFrozen(pInvestorPosition.getCombLongFrozen());
		ip.setCombPosition(pInvestorPosition.getCombPosition());
		ip.setCombShortFrozen(pInvestorPosition.getCombShortFrozen());
		ip.setCommission(pInvestorPosition.getCommission());
		ip.setExchangeMargin(pInvestorPosition.getExchangeMargin());
		ip.setFrozenCash(pInvestorPosition.getFrozenCash());
		ip.setFrozenCommission(pInvestorPosition.getFrozenCommission());
		ip.setFrozenMargin(pInvestorPosition.getFrozenMargin());
		ip.setHedgeFlag(pInvestorPosition.getHedgeFlag());
		ip.setInstrumentID(pInvestorPosition.getInstrumentID());
		ip.setInvestorID(pInvestorPosition.getInvestorID());
		ip.setLongFrozen(pInvestorPosition.getLongFrozen());
		ip.setLongFrozenAmount(pInvestorPosition.getLongFrozenAmount());
		ip.setMarginRateByMoney(pInvestorPosition.getMarginRateByMoney());
		ip.setMarginRateByVolume(pInvestorPosition.getMarginRateByVolume());
		ip.setOpenAmount(pInvestorPosition.getOpenAmount());
		ip.setOpenCost(pInvestorPosition.getOpenCost());
		ip.setOpenVolume(pInvestorPosition.getOpenVolume());
		ip.setPosiDirection(pInvestorPosition.getPosiDirection());
		ip.setPosition(pInvestorPosition.getPosition());
		ip.setPositionCost(pInvestorPosition.getPositionCost());
		ip.setPositionDate(pInvestorPosition.getPositionDate());
		ip.setPositionProfit(pInvestorPosition.getPositionProfit());
		ip.setPreMargin(pInvestorPosition.getPreMargin());
		ip.setPreSettlementPrice(pInvestorPosition.getPreSettlementPrice());
		System.out.println(ip);
		this.investorPositionDao.save(ip);
//		this.traderApiTriggerService.qryInvestorPositionDetail(pInvestorPosition.getBrokerID(), pInvestorPosition.getInstrumentID(), pInvestorPosition.getInvestorID());
	}

	@Override
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("查询资金账户："+pTradingAccount.getAvailable());
		TradingAccount account = this.tradingAccountDao.get(pTradingAccount.getBrokerID(), pTradingAccount.getAccountID());
		if(account==null){
			account = new TradingAccount();
			account.setId(sequenceService.generate(TradingAccount.class.getName()).getResult());
		}
		account.setAccountID(pTradingAccount.getAccountID());
		account.setAvailable(pTradingAccount.getAvailable());
		account.setBalance(pTradingAccount.getBalance());
		account.setBrokerID(pTradingAccount.getBrokerID());
		account.setCashIn(pTradingAccount.getCashIn());
		account.setCloseProfit(pTradingAccount.getCloseProfit());
		account.setCommission(pTradingAccount.getCommission());
		account.setCredit(pTradingAccount.getCredit());
		account.setCurrencyID(pTradingAccount.getCurrencyID());
		account.setCurrMargin(pTradingAccount.getCurrMargin());
		account.setDeliveryMargin(pTradingAccount.getDeliveryMargin());
		account.setDeposit(pTradingAccount.getDeposit());
		account.setExchangeDeliveryMargin(pTradingAccount.getExchangeDeliveryMargin());
		account.setExchangeMargin(pTradingAccount.getExchangeMargin());
		account.setFrozenCash(pTradingAccount.getFrozenCash());
		account.setFrozenCommission(pTradingAccount.getFrozenCommission());
		account.setFrozenMargin(pTradingAccount.getFrozenMargin());
		account.setFundMortgageAvailable(pTradingAccount.getFundMortgageAvailable());
		account.setFundMortgageIn(pTradingAccount.getFundMortgageIn());
		account.setFundMortgageOut(pTradingAccount.getFundMortgageOut());
		account.setInterest(pTradingAccount.getInterest());
		account.setInterestBase(pTradingAccount.getInterestBase());
		account.setMortgage(pTradingAccount.getMortgage());
		account.setMortgageableFund(pTradingAccount.getMortgageableFund());
		account.setPositionProfit(pTradingAccount.getPositionProfit());
		account.setPreBalance(pTradingAccount.getPreBalance());
		account.setPreCredit(pTradingAccount.getPreCredit());
		account.setPreDeposit(pTradingAccount.getPreDeposit());
		account.setPreFundMortgageIn(pTradingAccount.getPreFundMortgageIn());
		account.setPreFundMortgageOut(pTradingAccount.getPreFundMortgageOut());
		account.setPreMargin(pTradingAccount.getPreMargin());
		account.setPreMortgage(pTradingAccount.getPreMortgage());
		account.setReserve(pTradingAccount.getReserve());
		account.setReserveBalance(pTradingAccount.getReserveBalance());
		account.setSettlementID(pTradingAccount.getSettlementID());
		account.setSpecProductCloseProfit(pTradingAccount.getSpecProductCloseProfit());
		account.setSpecProductCommission(pTradingAccount.getSpecProductCommission());
		account.setSpecProductExchangeMargin(pTradingAccount.getSpecProductExchangeMargin());
		account.setSpecProductFrozenCommission(pTradingAccount.getSpecProductFrozenCommission());
		account.setSpecProductFrozenMargin(pTradingAccount.getSpecProductFrozenMargin());
		account.setSpecProductMargin(pTradingAccount.getSpecProductMargin());
		account.setSpecProductPositionProfit(pTradingAccount.getSpecProductPositionProfit());
		account.setSpecProductPositionProfitByAlg(pTradingAccount.getSpecProductPositionProfitByAlg());
		this.tradingAccountDao.save(account);
	}

	@Override
	public void OnRspQryInvestor(CThostFtdcInvestorField pInvestor, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryInvestor(pInvestor, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryTradingCode(pTradingCode, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		
	}

	@Override
	public void OnRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryInstrumentCommissionRate(pInstrumentCommissionRate, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryExchange(CThostFtdcExchangeField pExchange, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryExchange(pExchange, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryProduct(CThostFtdcProductField pProduct, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryProduct(pProduct, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if(pInstrument!=null){
			if(!this.instrumentService.isExists(pInstrument.getInstrumentID())){
				InstrumentDTO dto = new InstrumentDTO();
				dto.setCombinationType(pInstrument.getCombinationType());
				dto.setCreateDate(pInstrument.getCreateDate());
				dto.setDeliveryMonth(pInstrument.getDeliveryMonth());
				dto.setDeliveryYear(pInstrument.getDeliveryYear());
				dto.setEndDelivDate(pInstrument.getEndDelivDate());
				dto.setExchangeID(pInstrument.getExchangeID());
				dto.setExchangeInstID(pInstrument.getExchangeInstID());
				dto.setExpireDate(pInstrument.getExpireDate());
				dto.setInstLifePhase(pInstrument.getInstLifePhase());
				dto.setInstrumentID(pInstrument.getInstrumentID());
				dto.setInstrumentName(pInstrument.getInstrumentName());
				dto.setIsTrading(pInstrument.getIsTrading());
				dto.setLongMarginRatio(pInstrument.getLongMarginRatio());
				dto.setMaxLimitOrderVolume(pInstrument.getMaxLimitOrderVolume());
				dto.setMaxMarginSideAlgorithm(pInstrument.getMaxMarginSideAlgorithm());
				dto.setMaxMarketOrderVolume(pInstrument.getMaxMarketOrderVolume());
				dto.setMaxMarketOrderVolume(pInstrument.getMinLimitOrderVolume());
				dto.setMinMarketOrderVolume(pInstrument.getMinMarketOrderVolume());
				dto.setOpenDate(pInstrument.getOpenDate());
				dto.setOptionsType(pInstrument.getOptionsType());
				dto.setPositionDateType(pInstrument.getPositionDateType());
				dto.setPositionType(pInstrument.getPositionType());
				dto.setPriceTick(pInstrument.getPriceTick());
				dto.setProductClass(pInstrument.getProductClass());
				dto.setProductID(pInstrument.getProductID());
				dto.setShortMarginRatio(pInstrument.getShortMarginRatio());
				dto.setStartDelivDate(pInstrument.getStartDelivDate());
				dto.setStrikePrice(pInstrument.getStrikePrice());
				dto.setUnderlyingInstrID(pInstrument.getUnderlyingInstrID());
				dto.setUnderlyingMultiple(pInstrument.getUnderlyingMultiple());
				dto.setVolumeMultiple(pInstrument.getVolumeMultiple());
				instrumentService.addInstrument(dto);
			}
		}
	}

	@Override
	public void OnRspQryDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println(pDepthMarketData.getLastPrice());
		System.out.println("==============================OnRspQryDepthMarketData=========================");
	}

	@Override
	public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQrySettlementInfo(pSettlementInfo, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryTransferBank(CThostFtdcTransferBankField pTransferBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryTransferBank(pTransferBank, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField pInvestorPositionDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("====================OnRspQryInvestorPositionDetail======================");
		
		InvestorPositionDetail ipd = this.investorPositionDetailDao.getInvestorPositionDetail(pInvestorPositionDetail.getBrokerID(), pInvestorPositionDetail.getInstrumentID(), pInvestorPositionDetail.getInvestorID(), pInvestorPositionDetail.getTradeID());
		if(ipd==null){
			ipd = new InvestorPositionDetail();
			ipd.setId(this.sequenceService.generate(InvestorPositionDetail.class.getName()).getResult());
		}
		ipd.setBrokerID(pInvestorPositionDetail.getBrokerID());
		ipd.setCloseAmount(pInvestorPositionDetail.getCloseAmount());
		ipd.setCloseProfitByDate(pInvestorPositionDetail.getCloseProfitByDate());
		ipd.setCloseProfitByTrade(pInvestorPositionDetail.getCloseProfitByTrade());
		ipd.setCloseVolume(pInvestorPositionDetail.getCloseVolume());
		ipd.setCombInstrumentID(pInvestorPositionDetail.getCombInstrumentID());
		
		ipd.setDirection(pInvestorPositionDetail.getDirection());
		ipd.setExchangeID(pInvestorPositionDetail.getExchangeID());
		ipd.setExchMargin(pInvestorPositionDetail.getExchMargin());
		ipd.setHedgeFlag(pInvestorPositionDetail.getHedgeFlag());
		ipd.setInstrumentID(pInvestorPositionDetail.getInstrumentID());
		ipd.setInvestorID(pInvestorPositionDetail.getInvestorID());
		ipd.setLastSettlementPrice(pInvestorPositionDetail.getLastSettlementPrice());
		ipd.setMargin(pInvestorPositionDetail.getMargin());
		ipd.setMarginRateByMoney(pInvestorPositionDetail.getMarginRateByMoney());
		ipd.setMarginRateByVolume(pInvestorPositionDetail.getMarginRateByVolume());
		ipd.setOpenDate(pInvestorPositionDetail.getOpenDate());
		ipd.setOpenPrice(pInvestorPositionDetail.getOpenPrice());
		ipd.setPositionProfitByDate(pInvestorPositionDetail.getPositionProfitByDate());
		ipd.setPositionProfitByTrade(pInvestorPositionDetail.getPositionProfitByTrade());
		ipd.setSettlementID(pInvestorPositionDetail.getSettlementID());
		ipd.setSettlementPrice(pInvestorPositionDetail.getSettlementPrice());
		ipd.setTradeID(pInvestorPositionDetail.getTradeID());
		ipd.setTradeType(pInvestorPositionDetail.getTradeType());
		ipd.setTradingDay(pInvestorPositionDetail.getTradingDay());
		
		ipd.setVolume(pInvestorPositionDetail.getVolume());
		
		investorPositionDetailDao.save(ipd);
//		this.traderApiTriggerService.qryTradingAccount(pInvestorPositionDetail.getBrokerID(),pInvestorPositionDetail.getInvestorID());
	}

	@Override
	public void OnRspQryNotice(CThostFtdcNoticeField pNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryNotice(pNotice, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQrySettlementInfoConfirm(pSettlementInfoConfirm, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryInvestorPositionCombineDetail(pInvestorPositionCombineDetail, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryCFMMCTradingAccountKey(pCFMMCTradingAccountKey, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField pEWarrantOffset, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryEWarrantOffset(pEWarrantOffset, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryInvestorProductGroupMargin(CThostFtdcInvestorProductGroupMarginField pInvestorProductGroupMargin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryInvestorProductGroupMargin(pInvestorProductGroupMargin, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryExchangeMarginRate(CThostFtdcExchangeMarginRateField pExchangeMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryExchangeMarginRate(pExchangeMarginRate, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryExchangeMarginRateAdjust(CThostFtdcExchangeMarginRateAdjustField pExchangeMarginRateAdjust, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryExchangeMarginRateAdjust(pExchangeMarginRateAdjust, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryExchangeRate(CThostFtdcExchangeRateField pExchangeRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryExchangeRate(pExchangeRate, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQrySecAgentACIDMap(CThostFtdcSecAgentACIDMapField pSecAgentACIDMap, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQrySecAgentACIDMap(pSecAgentACIDMap, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryProductExchRate(CThostFtdcProductExchRateField pProductExchRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryProductExchRate(pProductExchRate, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryOptionInstrTradeCost(CThostFtdcOptionInstrTradeCostField pOptionInstrTradeCost, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryOptionInstrTradeCost(pOptionInstrTradeCost, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryOptionInstrCommRate(CThostFtdcOptionInstrCommRateField pOptionInstrCommRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryOptionInstrCommRate(pOptionInstrCommRate, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryExecOrder(CThostFtdcExecOrderField pExecOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryExecOrder(pExecOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryForQuote(CThostFtdcForQuoteField pForQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryForQuote(pForQuote, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryQuote(CThostFtdcQuoteField pQuote, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryQuote(pQuote, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryCombInstrumentGuard(CThostFtdcCombInstrumentGuardField pCombInstrumentGuard, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryCombInstrumentGuard(pCombInstrumentGuard, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryCombAction(CThostFtdcCombActionField pCombAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryCombAction(pCombAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryTransferSerial(CThostFtdcTransferSerialField pTransferSerial, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryTransferSerial(pTransferSerial, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryAccountregister(CThostFtdcAccountregisterField pAccountregister, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryAccountregister(pAccountregister, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("==========OnRspError===========");
		System.out.println(pRspInfo.getErrorID());
	}

	@Override
	public void OnRtnOrder(CThostFtdcOrderField pOrder) {
		System.out.println("================OnRtnOrder===========================");
		System.out.println("getOrderStatus:"+pOrder.getOrderStatus());
		System.out.println("getOrderSubmitStatus:"+pOrder.getOrderSubmitStatus());
		Order order = this.orderDao.getOrderByOrderRef(pOrder.getOrderRef());
		if(order==null){
			order = new Order();
			order.setId(this.sequenceService.generate(Order.class.getName()).getResult());
		}
		try {
			BeanUtils.copyProperties(order, pOrder);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		this.orderDao.save(order);
		if(order.getOrderSubmitStatus()=='0'){
			pOrder.getVolumeTraded();
		}
//		order.getCombHedgeFlag()
	}

	@Override
	public void OnRtnTrade(CThostFtdcTradeField pTrade) {
		System.out.println("=======================OnRtnTrade========================");
		
		//根据订单引用获取订单数据
		Trade trade = this.tradeDao.getTradeByOrderRef(pTrade.getOrderRef());
		if(trade==null){
			trade = new Trade();
			trade.setId(this.sequenceService.generate(Trade.class.getName()).getResult());
		}
		try {
			BeanUtils.copyProperties(trade, pTrade);
			trade.setTradeDateTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(trade.getTradeDate() + " "+trade.getTradeTime()).getTime());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.tradeDao.save(trade);
		//查询持仓信息
		this.traderApiTriggerService.qryInvestorPosition(pTrade.getBrokerID(), pTrade.getInstrumentID(), pTrade.getInvestorID());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.traderApiTriggerService.qryTradingAccount(pTrade.getBrokerID(), pTrade.getInvestorID());
		
	}

	@Override
	public void OnErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo) {
		System.out.println("====================OnErrRtnOrderInsert=====================");
		System.out.println(pRspInfo.getErrorID());
	}

	@Override
	public void OnErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnOrderAction(pOrderAction, pRspInfo);
	}

	@Override
	public void OnRtnInstrumentStatus(CThostFtdcInstrumentStatusField pInstrumentStatus) {
		// TODO Auto-generated method stub
		super.OnRtnInstrumentStatus(pInstrumentStatus);
	}

	@Override
	public void OnRtnTradingNotice(CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {
		// TODO Auto-generated method stub
		super.OnRtnTradingNotice(pTradingNoticeInfo);
	}

	@Override
	public void OnRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {
		// TODO Auto-generated method stub
		super.OnRtnErrorConditionalOrder(pErrorConditionalOrder);
	}

	@Override
	public void OnRtnExecOrder(CThostFtdcExecOrderField pExecOrder) {
		// TODO Auto-generated method stub
		super.OnRtnExecOrder(pExecOrder);
	}

	@Override
	public void OnErrRtnExecOrderInsert(CThostFtdcInputExecOrderField pInputExecOrder, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnExecOrderInsert(pInputExecOrder, pRspInfo);
	}

	@Override
	public void OnErrRtnExecOrderAction(CThostFtdcExecOrderActionField pExecOrderAction, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnExecOrderAction(pExecOrderAction, pRspInfo);
	}

	@Override
	public void OnErrRtnForQuoteInsert(CThostFtdcInputForQuoteField pInputForQuote, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnForQuoteInsert(pInputForQuote, pRspInfo);
	}

	@Override
	public void OnRtnQuote(CThostFtdcQuoteField pQuote) {
		// TODO Auto-generated method stub
		super.OnRtnQuote(pQuote);
	}

	@Override
	public void OnErrRtnQuoteInsert(CThostFtdcInputQuoteField pInputQuote, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnQuoteInsert(pInputQuote, pRspInfo);
	}

	@Override
	public void OnErrRtnQuoteAction(CThostFtdcQuoteActionField pQuoteAction, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnQuoteAction(pQuoteAction, pRspInfo);
	}

	@Override
	public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {
		// TODO Auto-generated method stub
		super.OnRtnForQuoteRsp(pForQuoteRsp);
	}

	@Override
	public void OnRtnCFMMCTradingAccountToken(CThostFtdcCFMMCTradingAccountTokenField pCFMMCTradingAccountToken) {
		// TODO Auto-generated method stub
		super.OnRtnCFMMCTradingAccountToken(pCFMMCTradingAccountToken);
	}

	@Override
	public void OnRtnCombAction(CThostFtdcCombActionField pCombAction) {
		// TODO Auto-generated method stub
		super.OnRtnCombAction(pCombAction);
	}

	@Override
	public void OnErrRtnCombActionInsert(CThostFtdcInputCombActionField pInputCombAction, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnCombActionInsert(pInputCombAction, pRspInfo);
	}

	@Override
	public void OnRspQryContractBank(CThostFtdcContractBankField pContractBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryContractBank(pContractBank, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryParkedOrder(pParkedOrder, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryParkedOrderAction(pParkedOrderAction, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryTradingNotice(CThostFtdcTradingNoticeField pTradingNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryTradingNotice(pTradingNotice, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField pBrokerTradingParams, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryBrokerTradingParams(pBrokerTradingParams, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQryBrokerTradingAlgos(pBrokerTradingAlgos, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQueryCFMMCTradingAccountToken(CThostFtdcQueryCFMMCTradingAccountTokenField pQueryCFMMCTradingAccountToken, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQueryCFMMCTradingAccountToken(pQueryCFMMCTradingAccountToken, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRtnFromBankToFutureByBank(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub
		super.OnRtnFromBankToFutureByBank(pRspTransfer);
	}

	@Override
	public void OnRtnFromFutureToBankByBank(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub
		super.OnRtnFromFutureToBankByBank(pRspTransfer);
	}

	@Override
	public void OnRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromBankToFutureByBank(pRspRepeal);
	}

	@Override
	public void OnRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromFutureToBankByBank(pRspRepeal);
	}

	@Override
	public void OnRtnFromBankToFutureByFuture(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub
		super.OnRtnFromBankToFutureByFuture(pRspTransfer);
	}

	@Override
	public void OnRtnFromFutureToBankByFuture(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub
		super.OnRtnFromFutureToBankByFuture(pRspTransfer);
	}

	@Override
	public void OnRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromBankToFutureByFutureManual(pRspRepeal);
	}

	@Override
	public void OnRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromFutureToBankByFutureManual(pRspRepeal);
	}

	@Override
	public void OnRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {
		// TODO Auto-generated method stub
		super.OnRtnQueryBankBalanceByFuture(pNotifyQueryAccount);
	}

	@Override
	public void OnErrRtnBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnBankToFutureByFuture(pReqTransfer, pRspInfo);
	}

	@Override
	public void OnErrRtnFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnFutureToBankByFuture(pReqTransfer, pRspInfo);
	}

	@Override
	public void OnErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnRepealBankToFutureByFutureManual(pReqRepeal, pRspInfo);
	}

	@Override
	public void OnErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnRepealFutureToBankByFutureManual(pReqRepeal, pRspInfo);
	}

	@Override
	public void OnErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub
		super.OnErrRtnQueryBankBalanceByFuture(pReqQueryAccount, pRspInfo);
	}

	@Override
	public void OnRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromBankToFutureByFuture(pRspRepeal);
	}

	@Override
	public void OnRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub
		super.OnRtnRepealFromFutureToBankByFuture(pRspRepeal);
	}

	@Override
	public void OnRspFromBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspFromBankToFutureByFuture(pReqTransfer, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspFromFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspFromFutureToBankByFuture(pReqTransfer, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
		super.OnRspQueryBankAccountMoneyByFuture(pReqQueryAccount, pRspInfo, nRequestID, bIsLast);
	}

	@Override
	public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {
		// TODO Auto-generated method stub
		super.OnRtnOpenAccountByBank(pOpenAccount);
	}

	@Override
	public void OnRtnCancelAccountByBank(CThostFtdcCancelAccountField pCancelAccount) {
		// TODO Auto-generated method stub
		super.OnRtnCancelAccountByBank(pCancelAccount);
	}

	@Override
	public void OnRtnChangeAccountByBank(CThostFtdcChangeAccountField pChangeAccount) {
		// TODO Auto-generated method stub
		super.OnRtnChangeAccountByBank(pChangeAccount);
	}
	public void setInstrumentService(InstrumentService instrumentService) {
		this.instrumentService = instrumentService;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

}
