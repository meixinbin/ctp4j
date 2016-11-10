package com.ctp.trader.service;

import java.util.List;

import com.ctp.trader.dto.InstrumentDTO;
import com.itqy8.framework.response.Response;
import com.itqy8.framework.response.VoidResponse;

public interface InstrumentService {

	/**
	 * 保存合约信息
	 * @param dto
	 * @return
	 */
	public VoidResponse addInstrument(InstrumentDTO dto);
	
	/**
	 * 获取所有合约
	 * @return
	 */
	public Response<List<InstrumentDTO>> getList();
	
	/**
	 * 获取所有合约代码
	 * @return
	 */
	public Response<List<String>> getInstrumentIds();
	
	public boolean isExists(String instrumentId);
}
