package io.mosip.pms.partner.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.mosip.pms.common.dto.FilterValueDto;
import io.mosip.pms.common.dto.PageResponseDto;
import io.mosip.pms.common.dto.PartnerPolicySearchResponseDto;
import io.mosip.pms.common.dto.PolicyRequestSearchResponseDto;
import io.mosip.pms.common.dto.SearchDto;
import io.mosip.pms.common.entity.PartnerType;
import io.mosip.pms.device.response.dto.FilterResponseCodeDto;
import io.mosip.pms.partner.request.dto.AddContactRequestDto;
import io.mosip.pms.partner.request.dto.CACertificateRequestDto;
import io.mosip.pms.partner.request.dto.ExtractorsDto;
import io.mosip.pms.partner.request.dto.PartnerAPIKeyRequest;
import io.mosip.pms.partner.request.dto.PartnerCertDownloadRequestDto;
import io.mosip.pms.partner.request.dto.PartnerCertificateRequestDto;
import io.mosip.pms.partner.request.dto.PartnerRequest;
import io.mosip.pms.partner.request.dto.PartnerSearchDto;
import io.mosip.pms.partner.request.dto.PartnerUpdateRequest;
import io.mosip.pms.partner.response.dto.APIkeyRequests;
import io.mosip.pms.partner.response.dto.CACertificateResponseDto;
import io.mosip.pms.partner.response.dto.DownloadPartnerAPIkeyResponse;
import io.mosip.pms.partner.response.dto.PartnerAPIKeyResponse;
import io.mosip.pms.partner.response.dto.PartnerCertDownloadResponeDto;
import io.mosip.pms.partner.response.dto.PartnerCertificateResponseDto;
import io.mosip.pms.partner.response.dto.PartnerCredentialTypePolicyDto;
import io.mosip.pms.partner.response.dto.PartnerResponse;
import io.mosip.pms.partner.response.dto.PartnerSearchResponseDto;
import io.mosip.pms.partner.response.dto.RetrievePartnerDetailsResponse;

public interface PartnerService {
	
	/** This method is used  for self registration by partner to create Auth/E-KYC Partners.
	 * @param request this class contains partner details
	 * @return partnerResponse this class contains status related to partner is registered successfully or not
	 */
	
	public PartnerResponse savePartner(PartnerRequest request);
	
	/** This method is used to retrieve Auth/E-KYC Partner details.
	 * @param partnerID this is unique id created after self registered by partner
	 * @return retrievePartnerDetailsResponse this class contains partner details
	 */
	public RetrievePartnerDetailsResponse getPartnerDetails(String partnerId);
	
	
	/**This method is used to update Auth/E-KYC Partner's details
	 * @param partnerUpdateRequest this class contains updated partner details
	 * @param partnerID this is unique id created after self registered by partner
	 * @return partnerResponse this class contains status of partner
	 */
	public PartnerResponse updatePartnerDetail(PartnerUpdateRequest partnerUpdateRequest,String partnerId);
	
	/**
	 * This method is used to submit Partner api key request.
	 * @param partnerAPIKeyRequest this class contains partner policy and policy description details 
	 * @param partnerID this is unique id created after self registered by partner
	 * @return partnerAPIKeyResponse this class contains partner request id and massage details
	 */
	public PartnerAPIKeyResponse submitPartnerApiKeyReq(PartnerAPIKeyRequest partnerAPIKeyRequest,String partnerId);
	
	/**
	 * This method is used to download Partner API key for the given APIKeyReqID.
	 * @param partnerID this is unique id created after self registered by partner
	 * @param aPIKeyReqID this is unique id created after partner request for Partner API Key
	 * @return downloadPartnerAPIkeyResponse this is unique id created once partner manager approved the partner API request
	 */
	
	public DownloadPartnerAPIkeyResponse getApikeyFromRequestKey(String partnerId,String aPIKeyReqId);
	
	/**
	 * This method is used to retrieve all API key requests submitted by partner till date.
	 * @param partnerID this is unique id created after self registered by partner
	 * @return partnersRetrieveApiKeyRequests this is a list of partner request for creation of partner API Key
	 */
	public List<APIkeyRequests> retrieveAllApiKeyRequestsSubmittedByPartner(String partnerId);
	
	/**
	 * 
	 * @param request
	 * @param partnerId
	 * @return
	 */
	public String createAndUpdateContactDetails(AddContactRequestDto request, String partnerId);
	
	/**
	 * Function to Upload CA/Sub-CA certificates
	 * 
	 * @param CACertificateRequestDto caCertResponseDto
	 * @return {@link CACertificateResponseDto} instance
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
    public CACertificateResponseDto uploadCACertificate(CACertificateRequestDto caCertResponseDto) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

    /**
     * Function to Upload Partner certificates
     * 
     * @param PartnerCertificateRequestDto partnerCertResponseDto
     * @return {@link PartnerCertificateResponseDto} instance
     * @throws IOException 
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
    */
    public PartnerCertificateResponseDto uploadPartnerCertificate(PartnerCertificateRequestDto partnerCertResponseDto) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;

    /**
     * Function to Download Partner certificates
     * 
     * @param FTPChipCertDownloadRequestDto certDownloadRequestDto
     * @return {@link PartnerCertDownloadResponeDto} instance
     * @throws IOException 
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
    */
    public PartnerCertDownloadResponeDto getPartnerCertificate(PartnerCertDownloadRequestDto certDownloadRequestDto) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException;
    
    /**
     * Function to add biometric extractors 
     * @param partnerId
     * @param policyId
     * @param extractors
     * @return
     */
    public String addBiometricExtractors(String partnerId, String policyId, ExtractorsDto extractors);
    
    /**
     * Function to get biometric extractors of partner and policy
     * @param partnerId
     * @param policyId
     * @return
     */
    public ExtractorsDto getBiometricExtractors(String partnerId, String policyId);
    
    /**
     * 
     * @param dto
     * @return
     */
	public PageResponseDto<PartnerSearchResponseDto> searchPartner(PartnerSearchDto dto);

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public PageResponseDto<PartnerType> searchPartnerType(SearchDto dto);
	
	/**
	 * 
	 * @return
	 */
	public String mapPartnerPolicyCredentialType(String credentialType,String partnerId,String policyId);
	
	/**
	 * 
	 * @param credentialType
	 * @param partnerId
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public PartnerCredentialTypePolicyDto getPartnerCredentialTypePolicy(String credentialType,String partnerId) throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * 
	 * @param deviceFilterValueDto
	 * @return
	 */
	public FilterResponseCodeDto filterValues(FilterValueDto filterValueDto);
	
	/**
	 * 
	 * @param filterValueDto
	 * @return
	 */
	public FilterResponseCodeDto apiKeyRequestFilter(FilterValueDto filterValueDto);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public PageResponseDto<PartnerPolicySearchResponseDto> searchPartnerApiKeys(SearchDto dto);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public PageResponseDto<PolicyRequestSearchResponseDto> searchPartnerApiKeyRequests(SearchDto dto);
}