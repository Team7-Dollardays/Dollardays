package com.dollardays.listners;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.reporter.BasicFileReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.ViewStyle;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class CustomExtentSparkReporter extends BasicFileReporter {
	
	
	private String htmlFileName = "";
	private static final String REPORTER_NAME = "spark";
	private static final String DEFAULT_TEMPLATE_NAME = REPORTER_NAME + "/spark.spa.ftl";
	private static final String[] DEFAULT_CONFIG_FILE_PATH = new String[] { "spark.properties",
	"src/main/resources/spark.properties" };
	private ViewStyle viewStyle =  ViewStyle.DEFAULT;;
	ExtentSparkReporter spark = null;
	public CustomExtentSparkReporter(String path) {
		super(path);
		spark = new ExtentSparkReporter(path);
		init(DEFAULT_CONFIG_FILE_PATH, config());
	}

	public CustomExtentSparkReporter(File file) {
		super(file);
		init(DEFAULT_CONFIG_FILE_PATH, config());
	}

	public CustomExtentSparkReporter(String path, ViewStyle viewStyle) {
		this(path);
		setViewStyle(viewStyle);
	}

	public CustomExtentSparkReporter(File file, ViewStyle viewStyle) {
		this(file);
		setViewStyle(viewStyle);
	}

	public ExtentSparkReporterConfiguration config() {
		return spark.config();
	}
	
	public void SetHtmlFileName(String htmlfile)
	{
		this.htmlFileName = htmlfile;
	}
	
	@Override
	public synchronized void flush(ReportAggregates reportAggregates) {
		super.flush(reportAggregates);
		if (getTestList().isEmpty()) {
			return;
		}
	
    	loadUserConfig();
    	
    	try {
    		if (viewStyle == ViewStyle.DEFAULT) {
			Template template = getFreemarkerConfig().getTemplate(DEFAULT_TEMPLATE_NAME);
				processTemplate(template, new File(getDestinationPath() + htmlFileName));
				return;
			}
    		
    	} catch (IOException | TemplateException e) {
			//logger.log(Level.SEVERE, "An exception occurred", e);
	}

	}
	
	private void setViewStyle(ViewStyle viewStyle) {
		this.viewStyle = viewStyle;
	}


	@Override
	public String getReporterName() {
		// TODO Auto-generated method stub
		return REPORTER_NAME;
	}


}
