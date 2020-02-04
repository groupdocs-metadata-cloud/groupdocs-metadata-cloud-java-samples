package examples.MetadataOperations.SetMetadata;

import java.util.ArrayList;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.MatchOptions;
import com.groupdocs.cloud.metadata.model.NameOptions;
import com.groupdocs.cloud.metadata.model.SearchCriteria;
import com.groupdocs.cloud.metadata.model.SetOptions;
import com.groupdocs.cloud.metadata.model.SetProperty;
import com.groupdocs.cloud.metadata.model.SetResult;
import com.groupdocs.cloud.metadata.model.requests.SetRequest;

import examples.Common;

/**
 * This example demonstrates how to set metadata by match property name exact word (ignorecase).
 */
public class SetMetadataByPropertyNameMatchWholeWord {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			SetOptions options = new SetOptions();
			ArrayList<SetProperty> properties = new ArrayList<SetProperty>();
			SetProperty property = new SetProperty();
			SearchCriteria searchCriteria = new SearchCriteria();
			NameOptions nameOptions = new NameOptions();
			nameOptions.setValue("NameOfApplication");
			MatchOptions matchOptions = new MatchOptions();
			matchOptions.setWholeWord(true);
			nameOptions.setMatchOptions(matchOptions);
			searchCriteria.setNameOptions(nameOptions);
			property.setSearchCriteria(searchCriteria);
			property.setNewValue("microsoft word office");
			property.setType("string");
			properties.add(property);
			options.setProperties(properties);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.xlsx");
			options.setFileInfo(fileInfo);
			SetRequest request = new SetRequest(options);

			SetResult response = apiInstance.set(request);

			System.out.println("Count of changes: " + response.getSetCount());
			System.out.println("Resultant file path: " + response.getPath());

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}