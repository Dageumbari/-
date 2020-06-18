package com.bit.model.service;

import java.util.List;


import com.bit.model.dto.space.DraftDTO;

public interface SpaceService {
	 List<DraftDTO> getSavedDraft();
}
