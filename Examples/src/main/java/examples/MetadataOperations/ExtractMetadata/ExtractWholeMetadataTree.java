package examples.MetadataOperations.ExtractMetadata;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.ExtractOptions;
import com.groupdocs.cloud.metadata.model.ExtractResult;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.MetadataProperty;
import com.groupdocs.cloud.metadata.model.Tag;
import com.groupdocs.cloud.metadata.model.requests.ExtractRequest;

import examples.Common;

/**
 * This example demonstrates how to extract whole metadata tree.
 */
public class ExtractWholeMetadataTree {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			ExtractOptions options = new ExtractOptions();
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.xlsx");
			options.setFileInfo(fileInfo);
			options.setFileInfo(fileInfo);
			ExtractRequest request = new ExtractRequest(options);

			ExtractResult response = apiInstance.extract(request);

			for (MetadataProperty entry : response.getMetadataTree().getInnerPackages().get(0).getPackageProperties()) {
				System.out.println(entry.getName() + ": " + entry.getValue());
				if (entry.getTags() == null)
					continue;
				for (Tag tagItem : entry.getTags()) {
					System.out.println(
							"Tag for property: name - " + tagItem.getName() + ", category - " + tagItem.getCategory());
				}
			}

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}