/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabsol.fb.model;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ali Zaidi
 */
public class BusinessVO {
    private String businessProfileId;
    private String companyName;
    private String businessTypeId;
    private String businessTypeTitle;
    private String businessCategoryId;
    private String businessCategoryTitle;
    private String businessNatureId;
    private String businessNatureTitle;
    private String serviceTypeId;
    private String serviceTypeTitle;
    private String contactPerson;
    private String phoneNo;
    private String mobileNo;
    private String[] address;
    private String filePath;
    private String termOfSupply;
    private MultipartFile companyLogo;
    private MultipartFile visitingCard;
    private String username;
    private String regNo;
    private String url;
    private String email;
    private MultipartFile coverImage;
    private String[] siteName;
    private String[] adminName;
    private String[] adminMobileNo;
    private String[] sitePhoneNo;
    private String[] adminEmail;
    private String[] provinceId;
    private String[] cityId;
    private String[] areaId;

    
    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getBusinessTypeTitle() {
        return businessTypeTitle;
    }

    public void setBusinessTypeTitle(String businessTypeTitle) {
        this.businessTypeTitle = businessTypeTitle;
    }

    public String getBusinessProfileId() {
        return businessProfileId;
    }

    public void setBusinessProfileId(String businessProfileId) {
        this.businessProfileId = businessProfileId;
    }

    public String getBusinessCategoryId() {
        return businessCategoryId;
    }

    public void setBusinessCategoryId(String businessCategoryId) {
        this.businessCategoryId = businessCategoryId;
    }

    public String getBusinessCategoryTitle() {
        return businessCategoryTitle;
    }

    public void setBusinessCategoryTitle(String businessCategoryTitle) {
        this.businessCategoryTitle = businessCategoryTitle;
    }

    public String getBusinessNatureId() {
        return businessNatureId;
    }

    public void setBusinessNatureId(String businessNatureId) {
        this.businessNatureId = businessNatureId;
    }

    public String getBusinessNatureTitle() {
        return businessNatureTitle;
    }

    public void setBusinessNatureTitle(String businessNatureTitle) {
        this.businessNatureTitle = businessNatureTitle;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeTitle() {
        return serviceTypeTitle;
    }

    public void setServiceTypeTitle(String serviceTypeTitle) {
        this.serviceTypeTitle = serviceTypeTitle;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    

    public MultipartFile getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(MultipartFile companyLogo) {
        this.companyLogo = companyLogo;
    }

    public MultipartFile getVisitingCard() {
        return visitingCard;
    }

    public void setVisitingCard(MultipartFile visitingCard) {
        this.visitingCard = visitingCard;
    }

    public String getTermOfSupply() {
        return termOfSupply;
    }

    public void setTermOfSupply(String termOfSupply) {
        this.termOfSupply = termOfSupply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSiteName() {
        return siteName;
    }

    public void setSiteName(String[] siteName) {
        this.siteName = siteName;
    }

    public String[] getAdminName() {
        return adminName;
    }

    public void setAdminName(String[] adminName) {
        this.adminName = adminName;
    }

    public String[] getAdminMobileNo() {
        return adminMobileNo;
    }

    public void setAdminMobileNo(String[] adminMobileNo) {
        this.adminMobileNo = adminMobileNo;
    }

    public String[] getSitePhoneNo() {
        return sitePhoneNo;
    }

    public void setSitePhoneNo(String[] sitePhoneNo) {
        this.sitePhoneNo = sitePhoneNo;
    }

    public String[] getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String[] adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String[] getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String[] provinceId) {
        this.provinceId = provinceId;
    }

    public String[] getCityId() {
        return cityId;
    }

    public void setCityId(String[] cityId) {
        this.cityId = cityId;
    }

    public String[] getAreaId() {
        return areaId;
    }

    public void setAreaId(String[] areaId) {
        this.areaId = areaId;
    }
    
    
    
}
