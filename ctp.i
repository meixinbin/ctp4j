%module(directors="1") ctp

%include "typemaps.i"

%{
#include "./ctp/ThostFtdcMdApi.h"
#include "./ctp/ThostFtdcTraderApi.h"
#include "./ctp/ThostFtdcUserApiDataType.h"
#include "./ctp/ThostFtdcUserApiStruct.h"
%}

/* These symbols are NEVER used in original files */
%ignore TThostFtdcVirementTradeCodeType;
%ignore THOST_FTDC_VTC_BankBankToFuture;
%ignore THOST_FTDC_VTC_BankFutureToBank;
%ignore THOST_FTDC_VTC_FutureBankToFuture;
%ignore THOST_FTDC_VTC_FutureFutureToBank;

%ignore TThostFtdcFBTTradeCodeEnumType;
%ignore THOST_FTDC_FTC_BankLaunchBankToBroker;
%ignore THOST_FTDC_FTC_BrokerLaunchBankToBroker;
%ignore THOST_FTDC_FTC_BankLaunchBrokerToBank;
%ignore THOST_FTDC_FTC_BrokerLaunchBrokerToBank;

%include "various.i"
%apply char **STRING_ARRAY { char *ppInstrumentID[] };

%javaconst(1);

%feature("director") CThostFtdcMdSpi;
%include "./ctp/ThostFtdcMdApi.h"
%feature("director") CThostFtdcTraderSpi;
%include "./ctp/ThostFtdcTraderApi.h"
%include "./ctp/ThostFtdcUserApiDataType.h"
%include "./ctp/ThostFtdcUserApiStruct.h"
