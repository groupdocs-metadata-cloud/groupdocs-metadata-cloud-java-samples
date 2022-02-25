package examples.MetadataOperations.AddMetadata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.AddOptions;
import com.groupdocs.cloud.metadata.model.AddProperty;
import com.groupdocs.cloud.metadata.model.AddResult;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.SearchCriteria;
import com.groupdocs.cloud.metadata.model.Tag;
import com.groupdocs.cloud.metadata.model.TagOptions;
import com.groupdocs.cloud.metadata.model.requests.AddRequest;

import examples.Common;

/**
 * This example demonstrates how to add metadata by exact tag name and tag category.
 */
public class AddMetadataByTag {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			AddOptions options = new AddOptions();
			ArrayList<AddProperty> properties = new ArrayList<AddProperty>();
			AddProperty property = new AddProperty();
			SearchCriteria searchCriteria = new SearchCriteria();
			TagOptions tagOptions = new TagOptions();
			Tag tag = new Tag();
			tag.setName("Manager");
			tag.setCategory("Person");
			tagOptions.setExactTag(tag);
			searchCriteria.setTagOptions(tagOptions);
			property.setSearchCriteria(searchCriteria);
			property.setValue("Test User");
			property.setType("string");
			properties.add(property);
			options.setProperties(properties);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			options.setFileInfo(fileInfo);
			AddRequest request = new AddRequest(options);

			AddResult response = apiInstance.add(request);

			System.out.println("Count of changes: " + response.getAddedCount());
			System.out.println("Resultant file path: " + response.getPath());

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}