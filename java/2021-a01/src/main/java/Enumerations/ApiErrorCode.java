package Enumerations;

public enum ApiErrorCode {
	PROFILE_ENTITY_NOT_FOUND(1);
	
	private final Integer errorCode;
	
	private ApiErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
}
