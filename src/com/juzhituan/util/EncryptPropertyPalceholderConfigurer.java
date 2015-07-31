package com.juzhituan.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPalceholderConfigurer extends
		PropertyPlaceholderConfigurer
{
    private String password="12345678";
    private String[] encryptPropNames={"userName","password"};
    /**
     * 判断是否是需要加解密的属性
     * @param propertyName
     * @return 
     */
    private boolean isEncryptProp(String propertyName)
	{
	   for (String encryptPropName : encryptPropNames)
	   {
		  if (encryptPropName.equals(propertyName))
		  {
			return true;
		  }
	   }
	   return false;
	}
    @Override
    protected String convertProperty(String propertyName, String propertyValue)
    {
    	if (isEncryptProp(propertyName))
		{
			String decryptValue=EncryptionUtil.desDecryption(propertyValue, password);
			return decryptValue;
		}
    	else
    	{
    		return propertyValue;
		}
    }
}
