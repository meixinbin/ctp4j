package com.ctp.trader.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.trader.dao.InstrumentDao;
import com.ctp.trader.dto.InstrumentDTO;
import com.ctp.trader.entity.Instrument;
import com.ctp.trader.service.InstrumentService;
import com.itqy8.framework.response.Response;
import com.itqy8.framework.response.VoidResponse;
import com.itqy8.sequence.service.SequenceService;

public class InstrumentServiceImpl implements InstrumentService {

	private InstrumentDao instrumentDao;

	private SequenceService sequenceService;
	@Override
	public VoidResponse addInstrument(InstrumentDTO dto) {
		VoidResponse vr = new VoidResponse();
		Instrument ins = new Instrument();
		try {
			BeanUtils.copyProperties(ins, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		ins.setId(sequenceService.generate(Instrument.class.getName()).getResult());
		instrumentDao.save(ins);
		return vr;
	}

	public void setInstrumentDao(InstrumentDao instrumentDao) {
		this.instrumentDao = instrumentDao;
	}

	@Override
	public Response<List<InstrumentDTO>> getList() {
		Response<List<InstrumentDTO>> response = new Response<List<InstrumentDTO>>();
		List<Instrument> insLs = this.instrumentDao.getInstrumentList();
		if(insLs!=null){
			List<InstrumentDTO> dtoLs = new ArrayList<InstrumentDTO>();
			for(Instrument ins:insLs){
				InstrumentDTO dto = new InstrumentDTO();
				try {
					BeanUtils.copyProperties(dto, ins);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				dtoLs.add(dto);
			}
			response.setResult(dtoLs);
		}
		return response;
	}

	@Override
	public Response<List<String>> getInstrumentIds() {
		Response<List<String>> response = new Response<List<String>>();
		List<Instrument> ls = this.instrumentDao.getInstrumentList();
		if(ls!=null){
			List<String> codels = new ArrayList<String>();
			for(Instrument ins:ls){
				codels.add(ins.getInstrumentID());
			}
			response.setResult(codels);
		}
		return response;
	}

	@Override
	public boolean isExists(String instrumentId) {
		Instrument ins = this.instrumentDao.getInstrument(instrumentId);
		return ins==null? false:true;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

}
