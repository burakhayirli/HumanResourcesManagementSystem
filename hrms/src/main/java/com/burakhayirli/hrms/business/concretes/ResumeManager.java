/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.burakhayirli.hrms.business.abstracts.ResumeService;
import com.burakhayirli.hrms.core.utilities.cloudinary.CloudinaryService;
import com.burakhayirli.hrms.core.utilities.converters.DtoConverterService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.ResumeDao;
import com.burakhayirli.hrms.entities.concretes.Resume;
import com.burakhayirli.hrms.entities.dtos.ResumeAddDto;
import com.burakhayirli.hrms.entities.dtos.ResumeGetDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService,
			DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
		this.dtoConverterService = dtoConverterService;

	}

	@Override
	public Result add(ResumeAddDto resumeDto) {
//		if (resume.getLanguages() != null) {
//			resume.getLanguages().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getEducation() != null) {
//			resume.getEducation().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getTechnologies() != null) {
//			resume.getTechnologies().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getJobExperiences() != null) {
//			resume.getJobExperiences().forEach(lang -> lang.setResume(resume));
//		}

		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Kayıt Başarılı");

	}

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeGetDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class), "Data Listelendi");

	}

	@Override
	public Result saveImage(MultipartFile file, Long resumeId) {

		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");

	}

	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(Long id) {
		return new SuccessDataResult<List<ResumeGetDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAllByCandidateId(id), ResumeGetDto.class),
				"Data Listelendi");
	}

}
