package examples.MetadataOperations.RemoveMetadata;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.RemoveOptions;
import com.groupdocs.cloud.metadata.model.RemoveResult;
import com.groupdocs.cloud.metadata.model.SearchCriteria;
import com.groupdocs.cloud.metadata.model.ValueOptions;
import com.groupdocs.cloud.metadata.model.requests.RemoveRequest;

import examples.Common;

/**
 * This example demonstrates how to remove metadata by property value.
 */
public class RemoveMetadataByPropertyValue {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			RemoveOptions options = new RemoveOptions();
			SearchCriteria searchCriteria = new SearchCriteria();
			ValueOptions valueOptions = new ValueOptions();
			valueOptions.setValue("Microsoft Office Word");
			valueOptions.setType("string");
			searchCriteria.setValueOptions(valueOptions);
			options.setSearchCriteria(searchCriteria);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			options.setFileInfo(fileInfo);
			RemoveRequest request = new RemoveRequest(options);

			RemoveResult response = apiInstance.remove(request);

			System.out.println("Count of changes: " + response.getRemovedCount());
			System.out.println("Resultant file path: " + response.getPath());

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}